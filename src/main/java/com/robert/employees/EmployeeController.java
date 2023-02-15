package com.robert.employees;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // Annotates it as rest controller
@RequestMapping("/api/v1/employees") // Maps it to a specific end point
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping // Annotates it as get method
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.allEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{empEmail}")
    public ResponseEntity<Optional<Employee>> getSingleEmployee(@PathVariable String empEmail) { // annotates this variable passed as the path we get from @GetMapping
        return new ResponseEntity<Optional<Employee>>(employeeService.singleEmployee(empEmail), HttpStatus.OK);
    }
}
