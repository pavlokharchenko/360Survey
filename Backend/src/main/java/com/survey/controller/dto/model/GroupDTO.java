package com.survey.controller.dto.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Taras Danilchuk
 */
public class GroupDTO {

    @NotEmpty
    @Size(min = 1, max = 64)
    private String name;

    @NotEmpty
    @Email
    private String authorEmail;

    private Collection<String> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public Collection<String> getUsers() {
        if (users == null) {
            users = new ArrayList<>();
        }
        return users;
    }

    public void setUsers(Collection<String> users) {
        this.users = users;
    }

    public void addUser(String userName) {
        getUsers().add(userName);
    }
}
