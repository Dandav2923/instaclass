package com.clan.instaclass.instituteService.models.institute;

import lombok.Data;

@Data
public class PutInstituteRequest {
    private Integer id;
    private String name;
    private String username;
    private String password;
}
