package com.survey.controller.dto.model;

/**
 * UserDTO.java 12.03.2016, 2016
 */

/**
 * @author Taras Danilchuk
 *
 */
public class UserDTO {
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
