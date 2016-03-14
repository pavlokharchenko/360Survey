package com.survey.controller.dto.transformer;

/**
 * DtoTransformer.java 12.03.2016, 2016
 */

import org.springframework.core.convert.converter.Converter;

/**
 * @author Taras Danilchuk
 *
 */
public interface DTOTransformer<T, Y> extends Converter<T, Y> {
    T transformFromDTO(Y object);
    Y transformToDTO(T object);
}
