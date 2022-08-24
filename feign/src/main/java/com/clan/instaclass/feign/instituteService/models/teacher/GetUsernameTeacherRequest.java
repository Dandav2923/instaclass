package com.clan.instaclass.feign.instituteService.models.teacher;

import lombok.Data;

@Data
public class GetUsernameTeacherRequest {


    private String username;

    private Integer idInstitute;
}
