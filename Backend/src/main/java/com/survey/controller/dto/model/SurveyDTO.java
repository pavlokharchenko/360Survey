package com.survey.controller.dto.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Artur Myseliuk
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SurveyDTO {
    private String user, surveyName;
    private List<String> questions;
}
