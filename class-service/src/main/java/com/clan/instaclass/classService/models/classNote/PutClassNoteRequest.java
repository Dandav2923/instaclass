package com.clan.instaclass.classService.models.classNote;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PutClassNoteRequest {
    private Integer id;
    private String note;
    private LocalDate date;
    private Integer teacherId;
    private Integer classId;
}
