package com.clan.instaclass.classService.models.classTeacher;

import lombok.Data;

@Data
public class CreateClassTeacherRequest {
    private Integer teacherId, subjectId, classId;
}
