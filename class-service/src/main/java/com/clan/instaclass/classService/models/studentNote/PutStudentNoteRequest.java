package com.clan.instaclass.classService.models.studentNote;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PutStudentNoteRequest {
    private Integer id;
    private String note;
    private LocalDate date;
    private Integer teacherId;
    private Integer studentId;
    private Integer classId;
}
