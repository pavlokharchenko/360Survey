package com.survey.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static java.util.Arrays.asList;

/**
 * @author Artur Myseliuk
 */
@Configuration
@EnableMongoRepositories
public class MongoConfiguration /*extends AbstractMongoConfiguration*/ {
    //TODO use property file

    public
    @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        //MongoClientOptions.builder().build();

        String databaseName = "survey";
        return new SimpleMongoDbFactory(
                new MongoClient(new ServerAddress("localhost", 27017),
                        asList(MongoCredential.createCredential("backend", databaseName, "survey".toCharArray()))),
                databaseName);
    }

    public
    @Bean
    MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory());
    }
}
