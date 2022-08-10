package com.clan.instaclass.classService.models.event;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PutEventRequest {
    private Integer id;
    private String name;
    private String description;
    private LocalDate date;
    private Integer classId;
}
