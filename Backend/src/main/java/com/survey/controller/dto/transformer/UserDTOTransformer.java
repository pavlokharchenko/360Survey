package com.survey.controller.dto.transformer;

/**
 * UserTransformer.java 12.03.2016, 2016
 */

import com.survey.controller.dto.model.UserDTO;
import com.survey.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author Taras Danilchuk
 */

@Component
public class UserDTOTransformer implements DTOTransformer<User, UserDTO> {

    @Override
    public User transformFromDTO(UserDTO object) {
        User user = new User();
        user.setEmail(object.getEmail());
        user.setName(object.getName());
        return user;
    }

    @Override
    public UserDTO transformToDTO(User object) {
        return UserDTO.builder().setName(object.getName()).setEmail(object.getEmail()).build();
    }

    @Override
    public UserDTO convert(User source) {
        return transformToDTO(source);
    }
}
