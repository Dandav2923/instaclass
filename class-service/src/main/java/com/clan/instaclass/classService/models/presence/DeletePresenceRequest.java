package com.clan.instaclass.classService.models.presence;

import lombok.Data;

@Data
public class DeletePresenceRequest {
    private Integer id;
    private Integer studentId, classId;
}
