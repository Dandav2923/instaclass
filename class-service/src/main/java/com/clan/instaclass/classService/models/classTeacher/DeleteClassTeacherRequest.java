package com.clan.instaclass.classService.models.classTeacher;

import lombok.Data;

@Data
public class DeleteClassTeacherRequest {
    Integer id, teacherId, classId;
}
