package org.contribute.mongo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan(basePackages = {"org.contribute.mongo"})
@EnableMongoRepositories(basePackages = {"org.contribute.mongo.data.access"})
@SpringBootApplication
public class SprintBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprintBootApplication.class, args);
    }

}