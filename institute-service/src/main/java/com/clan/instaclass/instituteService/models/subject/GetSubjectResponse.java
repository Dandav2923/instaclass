package com.clan.instaclass.instituteService.models.subject;

import lombok.Data;

@Data
public class GetSubjectResponse {
    private Integer id;
    private String name;
    private String description;
    private Integer instituteId;
}
