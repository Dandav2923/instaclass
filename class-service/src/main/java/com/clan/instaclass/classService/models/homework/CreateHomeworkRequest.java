package com.clan.instaclass.classService.models.homework;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateHomeworkRequest {
    private String assignment;
    private LocalDate date;
    private Integer subjectId;
    private Integer classId;
}
