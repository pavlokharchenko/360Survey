package com.survey.service.impl;

import com.survey.dao.UserRepository;
import com.survey.entity.User;
import com.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Artur Myseliuk
 */
@Service
public class UserServiceBean implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
