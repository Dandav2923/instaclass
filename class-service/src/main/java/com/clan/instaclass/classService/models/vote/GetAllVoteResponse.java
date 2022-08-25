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

    private String studentName;

    private String subjectName;

    private String teacherName;

    private Integer classEnt;

}
