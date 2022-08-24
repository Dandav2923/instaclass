package com.clan.instaclass.feign.instituteService.models.student;

import lombok.Data;


@Data
public class PutStudentResponse {
    private Integer id;

    private String name;

    private String surname;

    private String username;

    private String fiscalCode;

    private String password;


}
