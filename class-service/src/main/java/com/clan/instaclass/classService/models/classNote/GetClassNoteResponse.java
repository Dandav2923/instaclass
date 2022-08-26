package com.clan.instaclass.classService.models.classNote;

import lombok.Data;

import java.time.LocalDate;
@Data
public class GetClassNoteResponse {
    private Integer id;
    private String note;
    private LocalDate date;
    private String teacherName, teacherSurname, username, fiscalCode;
    private Integer classId;
}
