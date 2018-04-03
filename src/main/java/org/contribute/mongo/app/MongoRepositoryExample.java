package org.contribute.mongo.app;

import org.contribute.mongo.Customer;
import org.contribute.mongo.data.access.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Component
public class MongoRepositoryExample {

    private final Logger log = Logger.getLogger(MongoRepositoryExample.class.toString());

    @Autowired
    private CustomerRepository repository;


    public void cleanup() {
        repository.deleteAll();
    }

    public void findSomeByRepository() {
        // fetch all customers
        log.info("-------------------------------");
        for (Customer customer : repository.findByLastNameOrderByFirstNameAsc("Smith")) { // implemented by spring on the fly
            log.info("search results " + customer);
        }
    }


    public void insertCustomers() {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Alice", "Smith"));
        customers.add(new Customer("Bob", "Smith"));
        customers.add(new Customer("Rachel", "Smith"));
        customers.add(new Customer("Smith", "Smith"));

        customers.add(new Customer("Nikhil", "Middha"));
        customers.add(new Customer("Akarsh", "Bhutani"));

        customers.add(new Customer("Shankar", "Mishra"));
        customers.add(new Customer("Shikha", "Dadhich"));

        // save a couple of customers
        repository.saveAll(customers);
    }
}
