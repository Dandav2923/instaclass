package com.clan.instaclass.feign.instituteService.models.subject;

import lombok.Data;

@Data
public class CreateSubjectRequest {
    private String name;

    private Integer instituteId;
}
