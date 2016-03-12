package com.survey.dao;


import com.survey.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Artur Myseliuk
 */

public interface UserRepository  extends CrudRepository<User,String>{

}
