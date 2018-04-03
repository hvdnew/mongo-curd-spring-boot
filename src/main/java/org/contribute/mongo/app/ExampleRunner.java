package org.contribute.mongo.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ExampleRunner implements CommandLineRunner {

    private final Logger log = Logger.getLogger(ExampleRunner.class.toString());

    @Autowired
    MongoRepositoryExample repositoryExample;

    @Autowired
    MongoTemplateExample templateExample;

    @Override
    public void run(String... args) throws Exception {

        log.info("####################################################");
        runTemplate();

        log.info("####################################################");
        //runRepo();

    }

    private void runTemplate() {
        //templateExample.doSomeWitchCraft();
        templateExample.getMeSomeNiceMovies();
    }

    private void runRepo() {

        repositoryExample.cleanup();
        repositoryExample.insertCustomers();
        repositoryExample.findSomeByRepository();
    }
}
