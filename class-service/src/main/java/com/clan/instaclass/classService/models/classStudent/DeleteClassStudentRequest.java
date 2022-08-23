package com.clan.instaclass.classService.models.classStudent;

import lombok.Data;

@Data
public class DeleteClassStudentRequest {
    private Integer id,studentId, classId;
}
