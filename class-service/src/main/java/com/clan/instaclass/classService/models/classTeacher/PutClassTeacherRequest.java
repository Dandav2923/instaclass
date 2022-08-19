package com.clan.instaclass.classService.models.classTeacher;

import lombok.Data;

@Data
public class PutClassTeacherRequest {
    Integer id, teacherId, subjectId, classId;
}
