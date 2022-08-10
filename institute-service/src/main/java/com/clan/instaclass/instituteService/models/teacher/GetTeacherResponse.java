package com.clan.instaclass.instituteService.models.teacher;

import lombok.Data;

@Data
public class GetTeacherResponse {

    private Integer id;

    private String name;

    private String surname;

    private String username;

    private String fiscalCode;

    private String password;

    private Integer instituteId;
}
