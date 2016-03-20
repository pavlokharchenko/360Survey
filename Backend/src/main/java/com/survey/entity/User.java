package com.survey.entity;

/**
 * User.java 12.03.2016, 2016
 */

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author Taras Danilchuk
 */
@Data
@ToString(exclude = "password")
@Document
public class User {

    //@Indexed(unique = true)
    private String name,login,password;
    private boolean activated;

    @Id
    private String email;

}
