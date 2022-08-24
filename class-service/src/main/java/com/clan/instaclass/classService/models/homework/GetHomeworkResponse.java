package com.clan.instaclass.classService.models.homework;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetHomeworkResponse {
    private Integer id;
    private String assignment;
    private LocalDate date;
    private String subjectName;
    private Integer classId;
}
