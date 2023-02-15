package com.robert.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// THIS IS MODEL

@Document(collection = "employees")

@Data // takes care of setters, getters, and toString methods
@AllArgsConstructor // takes care of constructor
@NoArgsConstructor // takes care of constructor
public class Employee {
    @Id
    private ObjectId id;
    private String empName;
    private String empEmail;
    private String empPassword;
    private String empRole;
    @DocumentReference // tells DB to store only ids of this collection, and the data will be in separate collection
    private List<Holiday> holidayList;
    @DocumentReference // tells DB to store only ids of this collection, and the data will be in separate collection
    private List<Sickday> sickdayList;

    public Employee(String empName, String empEmail, String empPassword, String empRole) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPassword = empPassword;
        this.empRole = empRole;
    }
}
