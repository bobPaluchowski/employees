package com.robert.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController // Annotates it as rest controller
@RequestMapping("/api/v1/employees") // Maps it to a specific end point
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @DeleteMapping("/{empEmail}")
    public String deleteEmployee(@PathVariable String empEmail) {
        return employeeService.deleteEmployee(empEmail);
    }

    @PostMapping
//    @RequestMapping(value = "createEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping // Annotates it as get method
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<List<Employee>>(employeeService.allEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{empEmail}")
    public ResponseEntity<Optional<Employee>> getSingleEmployee(@PathVariable String empEmail) { // annotates this variable passed as the path we get from @GetMapping
        return new ResponseEntity<Optional<Employee>>(employeeService.singleEmployee(empEmail), HttpStatus.OK);
    }

//    @PutMapping
//    public Employee updateEmployee(@RequestBody Employee employee) {
//        return employeeService.updateEmployee(employee);
//    }

}
