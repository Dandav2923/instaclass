package com.clan.instaclass.classService.models.communication;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCommunicationRequest {
    private String communication;
    private LocalDate date;
    private Integer teacherId;
    private Integer classId;
}
