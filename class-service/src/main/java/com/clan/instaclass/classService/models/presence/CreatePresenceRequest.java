package com.clan.instaclass.classService.models.presence;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePresenceRequest {
    private Boolean present;
    private LocalDate date;
    private Integer studentId, classId;
}
