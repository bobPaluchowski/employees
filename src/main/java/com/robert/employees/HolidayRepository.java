package com.robert.employees;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidayRepository extends MongoRepository<Holiday, ObjectId> {
}
