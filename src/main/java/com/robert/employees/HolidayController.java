package com.robert.employees;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/holidays")
public class HolidayController {
    @Autowired
    private HolidayService holidayService;
    @Autowired
    private EmployeeService employeeService;

    @DeleteMapping("/{id}")
    public String deleteHoliday(@PathVariable ObjectId id) {
        return holidayService.deleteHoliday(id);
    }

    @GetMapping("/{empEmail}")
    public List<Holiday> getAllHolidays(@PathVariable String empEmail) {
        return (List<Holiday>) holidayService.allHolidays(empEmail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Holiday>> getSingleHoliday(@PathVariable ObjectId id) {
        return  new ResponseEntity<Optional<Holiday>>(holidayService.singleHoliday(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Holiday> createHoliday(@RequestBody Map<String, String> payload) {
        // Map is mapping each entry from payload to a key - value pair in database
        // This should take employee's email to insert the holiday into the specific employee
        return new ResponseEntity<Holiday>(holidayService.createHoliday(payload.get("empEmail"),payload.get("startDate"), payload.get("endDate"), payload.get("employeeEmail")), HttpStatus.CREATED);
    }
}
