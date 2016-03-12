package com.survey.controller;


import com.survey.controller.dto.model.UserDTO;
import com.survey.controller.dto.transformer.UserDTOTransformer;
import com.survey.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/user/{id}", produces = "application/json")
    public UserDTO getUser(@PathVariable String id){
        return new UserDTO("ss", "safgasf");
    }

    @RequestMapping(value = "/user/add/", method = RequestMethod.POST, consumes = "application/json")
    public String addUser(@RequestBody UserDTO userDTO) {
        LOGGER.debug("hellko");
        userService.addUser(userDTOTransformer.transformFromDTO(userDTO));
        return "hello";
    }

}
