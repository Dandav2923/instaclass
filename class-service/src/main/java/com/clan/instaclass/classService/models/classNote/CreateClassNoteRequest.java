package com.clan.instaclass.classService.models.classNote;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateClassNoteRequest {
    private String note;
    private LocalDate date;
    private Integer teacherId;
    private Integer classId;
}
