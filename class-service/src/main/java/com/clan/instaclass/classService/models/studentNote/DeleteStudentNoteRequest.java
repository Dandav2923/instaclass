package com.clan.instaclass.classService.models.studentNote;

import lombok.Data;

@Data
public class DeleteStudentNoteRequest {
    private Integer id;
    private Integer teacherId;
    private Integer studentId;
    private Integer classId;
}
