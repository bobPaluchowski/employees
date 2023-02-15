package com.robert.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


@Service
public class HolidayService {
    @Autowired
    private HolidayRepository holidayRepository; // Bringing in repository

    @Autowired
    private MongoTemplate mongoTemplate; // It is the way to write queries

    public Holiday createHoliday
            (String startDate, String endDate, String empEmail) {
//        Holiday holiday = new Holiday(startDate, endDate);
//        holidayRepository.insert(holiday);

        Holiday holiday = holidayRepository.insert(new Holiday(startDate, endDate)); // Change it

        // This will perform an update on the employee
        mongoTemplate.update(Employee.class)
                .matching(Criteria.where("empEmail").is(empEmail))
                .apply(new Update().push("holidays").value(holiday)).first();
        return holiday;
    }
}
