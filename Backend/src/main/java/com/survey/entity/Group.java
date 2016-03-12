package com.survey.entity;

import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * @author Taras Danilchuk
 */
public class Group extends AbstractDocument {

    private String name;
    @DBRef
    private User author;
    @DBRef
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
