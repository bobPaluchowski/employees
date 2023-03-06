package com.robert.employees;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HolidayRepository extends MongoRepository<Holiday, ObjectId> {

    Holiday findHolidaysByEmpEmail(String empEmail);

//    Optional<Holiday> findHolidayById(ObjectId id);

    void deleteById(ObjectId id);
}
