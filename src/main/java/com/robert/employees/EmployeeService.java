package com.robert.employees;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // To let the framework know it is a service
public class EmployeeService {
    @Autowired // This tells framework to instantiate this class for us
    private EmployeeRepository employeeRepository; // This is instantiated automatically
    public List<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> singleEmployee(String empEmail) { // it returns optional because it can return null
        return employeeRepository.findEmployeeByEmpEmail(empEmail);
    }
}
