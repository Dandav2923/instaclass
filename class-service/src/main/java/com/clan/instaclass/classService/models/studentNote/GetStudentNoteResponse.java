package com.clan.instaclass.classService.models.studentNote;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetStudentNoteResponse {
    private Integer id;
    private String note;
    private LocalDate date;
    private String teacherName, teacherSurname, username, fiscalCode;
    private String nameStudent;
    private String surnameStudent;
    private String usernameStudent;
    private String fiscalCodeStudent;
    private Integer classId;
}
