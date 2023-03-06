package com.robert.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

// THIS IS MODEL

@Document(collection = "holidays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Holiday {
    @Id
    private ObjectId id;
    private String empEmail;
    private String startDate;
    private String endDate;

    public Holiday(String empEmail, String startDate, String endDate) {
        this.empEmail = empEmail;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
