package com.survey.controller.dto.transformer;

import com.survey.controller.dto.model.GroupDTO;
import com.survey.entity.Group;
import org.springframework.stereotype.Component;

/**
 * @author Taras Danylchuk
 */
@Component
public class GroupDTOConverter implements DTOConverter<Group, GroupDTO> {

    @Override
    public GroupDTO convert(Group source) {
        GroupDTO group = new GroupDTO();
        group.setName(source.getName());
        group.setAuthorEmail(source.getAuthor().getEmail());
        source.getUsers().stream().forEach(user -> group.addUser(user.getEmail()));
        return group;
    }

    @Override
    public Group convertFromDTO(GroupDTO groupDTO) {
        Group group = new Group();
        group.setName(groupDTO.getName());
        //TODO: implement for users
        return group;
    }
}
