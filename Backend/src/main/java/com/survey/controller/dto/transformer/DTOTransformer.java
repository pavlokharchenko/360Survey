package com.survey.controller.dto.transformer;

/**
 * DtoTransformer.java 12.03.2016, 2016
 */

/**
 * @author Taras Danilchuk
 *
 */
public interface DTOTransformer<T, Y> {
    T transformFromDTO(Y object);
    Y transformToDTO(T object);
}
