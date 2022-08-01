package com.clan.superAdmin.controller;

import com.clan.superAdmin.entity.SuperAdmin;
import com.clan.superAdmin.repository.SuperAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/superAdmin",produces = MediaType.APPLICATION_JSON_VALUE)
public class SuperAdminController {

    @Autowired
    private SuperAdminRepository superAdminRepository;

    @PostMapping(path = "",consumes = "application/json" )
    public ResponseEntity<SuperAdmin> addRegisterSuperAdmin(@RequestBody SuperAdmin sa) {
        try {
            SuperAdmin addSuperAdmin = superAdminRepository.save(sa);
            return new ResponseEntity<SuperAdmin>(addSuperAdmin, HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<SuperAdmin>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
