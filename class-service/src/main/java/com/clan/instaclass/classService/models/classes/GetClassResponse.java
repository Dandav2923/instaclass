package com.clan.instaclass.classService.models.classes;

import lombok.Data;

@Data
public class GetClassResponse {
    private Integer id;
    private String nome;
    private Integer InstituteId;
}
