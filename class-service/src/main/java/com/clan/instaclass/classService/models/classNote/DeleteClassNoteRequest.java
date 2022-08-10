package com.clan.instaclass.classService.models.classNote;

import lombok.Data;

@Data
public class DeleteClassNoteRequest {
    private Integer id, teacherId, classId;
}
