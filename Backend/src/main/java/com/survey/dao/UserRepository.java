package com.survey.dao;


import com.survey.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * @author Artur Myseliuk
 */
@Component
public interface UserRepository extends MongoRepository<User, String> {

}
