package com.clan.instaclass.feign.instituteService.models.institute;

import lombok.Data;

@Data
public class CreateInstituteRequest {
    private String name;
    private String username;
    private String password;

}
