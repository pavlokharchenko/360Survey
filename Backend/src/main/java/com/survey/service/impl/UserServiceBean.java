package com.survey.service.impl;

import com.survey.dao.UserRepository;
import com.survey.entity.User;
import com.survey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Artur Myseliuk
 */
@Service
public class UserServiceBean implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User find(String email) {
        return userRepository.findOne(email);
    }

    @Override
    public boolean isExist(User user) {
        return userRepository.exists(user.getEmail());
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
