package com.survey.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collections;

/**
 * @author Artur Myseliuk
 */
@Configuration
@EnableMongoRepositories
@PropertySource(value = "classpath:360Survey.properties")
public class MongoConfiguration {

    @Value(value = "mongo.server.host")
    private String mongoServerHost;
    @Value(value = "mongo.server.port")
    private String mongoServerPost;
    @Value(value = "mongo.server.password")
    private String mongoServerPassword;
    @Value(value = "mongo.server.user")
    private String mongoServerUser;
    @Value(value = "mongo.db.name")
    private String mongoDatabaseName;

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(new ServerAddress(mongoServerHost, Integer.valueOf(mongoServerPost)),
                        Collections.singletonList(MongoCredential.createCredential(mongoServerUser, mongoDatabaseName, mongoServerPassword.toCharArray()))),
                mongoDatabaseName);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) throws Exception {
        return new MongoTemplate(mongoDbFactory);
    }
}
