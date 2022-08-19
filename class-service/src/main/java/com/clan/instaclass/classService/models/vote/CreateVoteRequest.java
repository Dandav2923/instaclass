package com.clan.instaclass.classService.models.vote;

import com.clan.instaclass.classService.entities.ClassEnt;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateVoteRequest {

    private Integer vote;

    private LocalDate date;

    private Integer studenId;

    private Integer subjectId;

    private Integer teacherId;

    private Integer classEntId;
}
