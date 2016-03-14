package com.survey.controller.dto.transformer;

/**
 * DtoTransformer.java 12.03.2016, 2016
 */

import org.springframework.core.convert.converter.Converter;

/**
 * @author Taras Danilchuk
 */
public interface DTOConverter<S, T> extends Converter<S, T> {
    S convertFromDTO(T object);
}
