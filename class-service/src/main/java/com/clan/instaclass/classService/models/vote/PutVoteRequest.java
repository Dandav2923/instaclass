package com.clan.instaclass.classService.models.vote;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PutVoteRequest {

    private Integer id;

    private LocalDate date;

    private  Integer vote;

    private Integer docenteId;
}
