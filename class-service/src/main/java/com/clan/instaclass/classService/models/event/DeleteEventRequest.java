package com.clan.instaclass.classService.models.event;

import lombok.Data;

@Data
public class DeleteEventRequest {
    private Integer id;
    private Integer classId;
}
