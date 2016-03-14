package com.survey.controller;


import com.survey.controller.dto.model.UserDTO;
import com.survey.controller.dto.transformer.UserDTOConverter;
import com.survey.entity.User;
import com.survey.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

/**
 * @author Artur Myseliuk
 */

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private UserDTOConverter userDTOConverter;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UserDTO>> getUsers(Pageable pageable) {
        return new ResponseEntity<>(userService.findAll(pageable).map(userDTOConverter), HttpStatus.OK);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable String email) {
        UserDTO user = userDTOConverter.convert(userService.find(email));
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveUser(@Valid @RequestBody UserDTO userDTO, UriComponentsBuilder ucBuilder) {
        User user = userDTOConverter.convertFromDTO(userDTO);

        if (userService.isExist(user)) {
            LOGGER.warn("A User with e-mail " + user.getEmail() + " is already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userService.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{email}").buildAndExpand(user.getEmail()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

}
