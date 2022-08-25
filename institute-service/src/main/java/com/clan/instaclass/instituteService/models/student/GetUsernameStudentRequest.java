package com.clan.instaclass.instituteService.models.student;

import lombok.Data;


@Data
public class GetUsernameStudentRequest {
    private String username;
    private Integer instituteId;

}
