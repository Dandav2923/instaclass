package com.clan.instaclass.classService.models.vote;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetVoteResponse {
    private Integer id;
    private Integer vote;
    private LocalDate date;
    private String nameStudent;
    private String surnameStudent;
    private String usernameStudent;
    private String fiscalCodeStudent;
    private Integer subject;
    private String teacherName, teacherSurname, username, fiscalCode;
    private Integer classEnt;
}
