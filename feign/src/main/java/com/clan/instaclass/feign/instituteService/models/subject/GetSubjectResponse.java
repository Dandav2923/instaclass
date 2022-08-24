package com.clan.instaclass.feign.instituteService.models.subject;

import lombok.Data;

@Data
public class GetSubjectResponse {
    private Integer id;
    private String name;
    private Integer instituteId;
}
