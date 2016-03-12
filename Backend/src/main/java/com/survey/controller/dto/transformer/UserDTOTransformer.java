package com.survey.controller.dto.transformer;

/**
 * UserTransformer.java 12.03.2016, 2016
 */

import com.survey.controller.dto.model.UserDTO;
import com.survey.entity.User;
import org.springframework.stereotype.Component;

/**
 * @author Taras Danilchuk
 *
 */

@Component
public class UserDTOTransformer implements DTOTransformer<User, UserDTO> {

    @Override
    public User transformFromDTO(UserDTO object) {
        return null;
    }

    @Override
    public UserDTO transformToDTO(User object) {
        return null;
    }
}
