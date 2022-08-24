package com.clan.instaclass.classService.models.studentNote;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetStudentNoteResponse {
    private Integer id;
    private String note;
    private LocalDate date;
    private String teacherName;
    private String studentName;
    private Integer classId;
}
