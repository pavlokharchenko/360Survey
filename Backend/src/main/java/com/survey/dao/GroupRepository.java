package com.survey.dao;


import com.survey.entity.Group;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @author Artur Myseliuk
 */
@Component
public interface GroupRepository extends MongoRepository<Group, String> {

}
