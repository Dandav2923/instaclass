package com.clan.instaclass.classService.models.vote;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetVoteResponse {

    private Integer id;

    private Integer vote;

    private LocalDate date;

    private Integer student;

    private Integer subject;

    private Integer teacher;

    private Integer classEnt;
}
