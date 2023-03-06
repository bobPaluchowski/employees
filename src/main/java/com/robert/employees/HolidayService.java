package com.robert.employees;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class HolidayService {
    @Autowired
    private HolidayRepository holidayRepository; // Bringing in repository

    @Autowired
    private MongoTemplate mongoTemplate; // It is the way to write queries

    // Get all holidays
    public Holiday allHolidays(String empEmail) {
        return holidayRepository.findHolidaysByEmpEmail(empEmail);
    }

    // Get single holiday
    public Optional<Holiday> singleHoliday(ObjectId id) {
        return Optional.ofNullable(holidayRepository.findHolidaysByEmpEmail(String.valueOf(id)));
    }

    // Update holiday - maybe this method should take Employee instead of Holiday???
//    public Holiday updateHoliday(Holiday holiday) {
//        // Get existing holiday
//
//        // Update existing holiday
//
//        return
//    }

    // Delete holiday
    public String deleteHoliday(ObjectId id) {
        holidayRepository.deleteById(id);
        return "Your holiday has been deleted";
    }

    public Holiday createHoliday
            (String empEmail, String startDate, String endDate, String employeeEmail) {
        Holiday holiday = new Holiday(empEmail, startDate, endDate);
        holidayRepository.insert(holiday);

//        Holiday holiday = holidayRepository.insert(new Holiday(startDate, endDate)); // Change it

        // This will perform an update on the employee
        mongoTemplate.update(Employee.class)
                .matching(Criteria.where("empEmail").is(employeeEmail))
                .apply(new Update().push("holidays").value(holiday)).first();
        return holiday;
    }
}
