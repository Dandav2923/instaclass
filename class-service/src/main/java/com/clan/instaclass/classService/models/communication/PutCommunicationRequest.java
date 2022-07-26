package com.clan.instaclass.classService.models.communication;

import com.clan.instaclass.classService.entities.ClassEnt;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PutCommunicationRequest {
    private Integer id;
    private String communication;
    private LocalDate date;
    private Integer teacherId;
    private Integer classId;
}
