package com.survey.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Taras Danylchuk
 *
 */
public interface CRUDService<T, K> {

    void save(T object);

    boolean isExist(T object);

    Page<T> findAll(Pageable pageable);

    List<T> findAll();

    T find(K id);
}
