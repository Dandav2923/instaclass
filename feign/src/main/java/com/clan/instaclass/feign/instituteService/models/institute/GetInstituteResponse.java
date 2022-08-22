package com.clan.instaclass.feign.instituteService.models.institute;

import lombok.Data;

@Data
public class GetInstituteResponse {
    private Integer id;
    private String username;
    private String name;
}
