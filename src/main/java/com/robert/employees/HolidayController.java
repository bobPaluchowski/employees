package com.robert.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/holidays")
public class HolidayController {
    @Autowired
    private HolidayService holidayService;

    @PostMapping
    public ResponseEntity<Holiday> createHoliday(@RequestBody Map<String, String> payload) {
        // Map is mapping each entry from payload to a key - value pair in database
        // This should take employee's email to insert the holiday into the specific employee
        return new ResponseEntity<Holiday>(holidayService.createHoliday(payload.get("startDate"), payload.get("endDate"), payload.get("empEmail")), HttpStatus.CREATED);
    }
}
