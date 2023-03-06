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

    // Find all employees
    public List<Employee> allEmployees() {
        return employeeRepository.findAll();
    }

    // Create employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Find employee by email
    public Optional<Employee> singleEmployee(String empEmail) { // it returns optional because it can return null
        return employeeRepository.findEmployeeByEmpEmail(empEmail);
    }

    // Update employee
    public Employee updateEmployee(Employee employee) {
        // Get the existing employee from DB
        Employee existingEmployee = employeeRepository.findEmployeeByEmpEmail(employee.getEmpEmail()).get();
        // Update the existing employee
        existingEmployee.setEmpName(employee.getEmpName());
        existingEmployee.setEmpEmail(employee.getEmpEmail());
        existingEmployee.setEmpPassword(employee.getEmpPassword());
        existingEmployee.setEmpRole(employee.getEmpRole());
        existingEmployee.setHolidayList(employee.getHolidayList());
        existingEmployee.setSickdayList(employee.getSickdayList());
        return employeeRepository.save(existingEmployee);
    }

    // Delete employee
    public String deleteEmployee(String empEmail) {
        employeeRepository.deleteByEmpEmail(empEmail);
        return "User with "+ empEmail+ " was deleted from database";
    }
}
