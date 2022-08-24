package com.clan.instaclass.feign.instituteService.models.teacher;

import lombok.Data;

@Data
public class CreateTeacherRequest {

    private String name;

    private String surname;

    private String username;

    private String fiscalCode;

    private String password;

    private Integer instituteId;
}
