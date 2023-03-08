package com.robert.employees;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Holiday {

    @Id
    private String id;
    private Date startDate;
    private Date endDate;
    private LocalDateTime createdAt;
}
