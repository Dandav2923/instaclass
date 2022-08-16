package com.clan.superAdmin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("superAdmin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdmin {

    private String username;

    private String password;


}
