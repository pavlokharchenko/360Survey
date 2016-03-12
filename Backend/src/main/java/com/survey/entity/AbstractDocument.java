package com.survey.entity;

import org.springframework.data.annotation.Id;

/**
 * @author Taras Danilchuk
 */
public abstract class AbstractDocument {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
