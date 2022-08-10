package com.clan.instaclass.classService.models.presence;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetPresenceResponse {
    private Integer id;
    private Boolean present;
    private LocalDate date;
    private Integer studentId, classId;
}
