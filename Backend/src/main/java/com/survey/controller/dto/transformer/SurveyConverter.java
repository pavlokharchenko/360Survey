package com.survey.controller.dto.transformer;

import com.survey.controller.dto.model.SurveyDTO;
import com.survey.entity.Survey;

/**
 * @author Artur Myseliuk
 */

public class SurveyConverter implements DTOConverter<Survey, SurveyDTO>{
    @Override
    public Survey convertFromDTO(SurveyDTO object) {
        return new Survey();
    }

    @Override
    public SurveyDTO convert(Survey source) {
        return SurveyDTO.builder().build();
    }
}
