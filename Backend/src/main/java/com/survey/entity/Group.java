package com.survey.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * @author Taras Danilchuk
 */
@Data
public class Group {

    @Id
    private String name;
    @DBRef
    private User author;
    @DBRef
    private List<User> users;

}
