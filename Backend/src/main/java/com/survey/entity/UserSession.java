package com.survey.entity;

/**
 * UserSession.java 12.03.2016, 2016
 */

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Version;

/**
 * @author Taras Danilchuk
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class UserSession extends AbstractDocument {
    @Version
    private String version;

}
