package com.robert.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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
    private String id;
    private String empName;
    @Indexed(unique = true)
    private String empEmail;
    private String empPassword;
    private Role empRole;
    private Location location;
    private Site site;
//    @DocumentReference // tells DB to store only ids of this collection, and the data will be in separate collection
    private List<Holiday> holidays;
//    @DocumentReference // tells DB to store only ids of this collection, and the data will be in separate collection
    private List<Sickday> sickdays;

    public Employee(String empName, String empEmail, String empPassword, Role empRole, Location location, Site site, List<Holiday> holidays, List<Sickday> sickdays) {
        this.empName = empName;
        this.empEmail = empEmail;
        this.empPassword = empPassword;
        this.empRole = empRole;
        this.location = location;
        this.site = site;
        this.holidays = holidays;
        this.sickdays = sickdays;
    }
}
