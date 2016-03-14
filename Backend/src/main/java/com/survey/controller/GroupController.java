package com.survey.controller;


import com.survey.controller.dto.model.GroupDTO;
import com.survey.controller.dto.transformer.GroupDTOConverter;
import com.survey.entity.Group;
import com.survey.service.GroupService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

/**
 * @author Artur Myseliuk
 */

@RestController
@RequestMapping("/groups")
public class GroupController {

    private static final Logger LOGGER = LogManager.getLogger(GroupController.class);

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupDTOConverter groupDTOConverter;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<GroupDTO>> getGroups(Pageable pageable) {
        return new ResponseEntity<>(groupService.findAll(pageable).map(groupDTOConverter), HttpStatus.OK);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupDTO> getGroup(@PathVariable String name) {
        GroupDTO group = groupDTOConverter.convert(groupService.find(name));
        if (group == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(group, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveGroup(@Valid @RequestBody GroupDTO groupDTO, UriComponentsBuilder ucBuilder) {
        Group group = groupDTOConverter.convertFromDTO(groupDTO);

        if (groupService.isExist(group)) {
            LOGGER.warn("A Group with name " + group.getName() + " is already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        groupService.save(group);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/groups/{name}").buildAndExpand(group.getName()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
