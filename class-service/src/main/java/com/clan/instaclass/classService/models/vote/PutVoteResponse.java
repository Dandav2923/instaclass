package com.clan.instaclass.classService.models.vote;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PutVoteResponse {

    private Integer id;

    private LocalDate date;

    private Integer vote;
}
