package com.clan.instaclass.classService.models.classStudent;

import lombok.Data;

@Data
public class CreateClassStudentRequest {
    private Integer studentId, classId;
}
