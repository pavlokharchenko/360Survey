package com.survey.controller;


import com.survey.controller.dto.transformer.UserDTOTransformer;
import com.survey.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Artur Myseliuk
 */

@RestController
public class UserController {
    private static final Logger LOGGER = LogManager.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private UserDTOTransformer userDTOTransformer;

    @RequestMapping("/users/")
    public String getUsers() {
        return "users";
    }

    @RequestMapping("/")
    public String hello() {
        LOGGER.info("hellko");
        return "hello";
    }

}
