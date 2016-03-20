package com.survey.controller.dto.model;

/**
 * UserDTO.java 12.03.2016, 2016
 */

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * @author Taras Danilchuk
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    @NotEmpty
    @Size(min = 4, max = 64)
    private String name;

    @NotEmpty
    @Email
    private String email;


}
