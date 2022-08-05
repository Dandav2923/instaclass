package com.clan.instaclass.classService.models.classes;

import lombok.Data;

@Data
public class PutClassRequest {
    private Integer id;
    private String name;
    private Integer instituteId;
}
