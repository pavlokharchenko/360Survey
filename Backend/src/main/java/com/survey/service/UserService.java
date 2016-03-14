package com.survey.service;

/**
 * UserService.java 12.03.2016, 2016
 */

import com.survey.controller.dto.model.UserDTO;
import com.survey.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Taras Danilchuk
 */

public interface UserService {
    void saveUser(User user);

    User findByEmail(String email);

    boolean isUserExist(User user);

    Page<User> findAllUsers(Pageable pageable);
}
