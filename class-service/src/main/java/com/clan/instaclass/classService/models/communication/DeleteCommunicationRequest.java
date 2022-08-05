package com.clan.instaclass.classService.models.communication;

import com.clan.instaclass.classService.entities.ClassEnt;
import lombok.Data;

@Data
public class DeleteCommunicationRequest {
    private Integer id;
    private Integer teacherId;
    private ClassEnt classId;

}
