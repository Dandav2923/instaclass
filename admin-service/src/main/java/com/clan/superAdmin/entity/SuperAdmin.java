package com.clan.superAdmin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("superAdmin")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdmin {

    private String username;

    private String password;


}
