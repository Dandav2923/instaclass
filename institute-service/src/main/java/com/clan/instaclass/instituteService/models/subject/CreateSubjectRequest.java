package com.clan.instaclass.instituteService.models.subject;

import lombok.Data;

@Data
public class CreateSubjectRequest {
    private String name;
    private String description;
    private Integer instituteId;
}
