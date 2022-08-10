package com.clan.instaclass.classService.models.homework;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PutHomeworkResponse {
    private Integer id;
    private String assignment;
    private LocalDate date;
    private Integer subjectId;
    private Integer classId;
}
