package com.survey.controller.dto.model;

/**
 * UserDTO.java 12.03.2016, 2016
 */

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @author Taras Danilchuk
 */
public class UserDTO {

    @NotEmpty
    @Size(min = 4, max = 64)
    private String name;
    @NotEmpty
    @Email
    private String email;

    public UserDTO() {
    }

    public UserDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    private UserDTO(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        String name;
        String email;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDTO build() {
            return new UserDTO(this);
        }
    }
}
