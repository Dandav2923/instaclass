package com.clan.instaclass.classService.models.classTeacher;

import lombok.Data;

@Data
public class GetClassTeacherResponse {
    private Integer id, classId;
    private String subjectName;
    private String teacherName, teacherSurname, username, fiscalCode;
}
