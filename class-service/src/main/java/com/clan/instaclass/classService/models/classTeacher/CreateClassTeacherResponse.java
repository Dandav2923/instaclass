package com.clan.instaclass.classService.models.classTeacher;

import lombok.Data;

@Data
public class CreateClassTeacherResponse {
    private Integer id, teacherId, subjectId, classId;
}
