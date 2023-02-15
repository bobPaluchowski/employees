package com.robert.employees;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// THIS IS MODEL

@Document(collection = "sickdays")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sickday {
    @Id
    private ObjectId id;
    private String startData;
    private String endData;
}
