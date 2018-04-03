package org.contribute.mongo.data.access;

import org.contribute.mongo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastNameOrderByFirstNameAsc(String lastName);
}
