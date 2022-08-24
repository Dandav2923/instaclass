package com.clan.instaclass.feign.instituteService.models.teacher;

import lombok.Data;

import java.util.List;

@Data
public class ConnectTeacherSubjectRequest {

    private Integer teacherId;
    private List<Integer> subjectIdList;
}
