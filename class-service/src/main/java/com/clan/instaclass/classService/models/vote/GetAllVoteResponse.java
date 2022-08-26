package com.clan.instaclass.classService.models.vote;

import com.clan.instaclass.classService.entities.ClassEnt;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Data
public class GetAllVoteResponse {
    private Integer id;
    private Integer vote;
    private LocalDate date;
    private String nameStudent;
    private String surnameStudent;
    private String usernameStudent;
    private String fiscalCodeStudent;
    private String subjectName;
    private String teacherName, teacherSurname, username, fiscalCode;
    private Integer classEnt;
}
