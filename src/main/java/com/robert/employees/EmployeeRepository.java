package com.robert.employees;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // To let the framework know it is repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {
    // We can write a dynamic queries based on the database parameters like so:
    // This one returns single entity by different id
    // Optional<Employee> findEmployeeByDifferentId(String differentId);
    // Spring does understand what we want to do
    // Change Service and Controller accordingly

    Optional<Employee> findEmployeeByEmpEmail(String empEmail);
}
