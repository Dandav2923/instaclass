package com.clan.superAdminService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.ArrayList;
import java.util.List;


@Document("superAdmin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdmin {

    private int id;

    private String username;

    private String password;


}
