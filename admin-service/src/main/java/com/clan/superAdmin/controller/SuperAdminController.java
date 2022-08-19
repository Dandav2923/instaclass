package com.clan.superAdmin.controller;

import com.clan.superAdmin.entities.SuperAdmin;
import com.clan.superAdmin.exception.DataNotValidException;
import com.clan.superAdmin.exception.SuperAdminAlreadyExistingException;
import com.clan.superAdmin.models.CreateSuperAdminRequest;
import com.clan.superAdmin.models.CreateSuperAdminResponse;
import com.clan.superAdmin.repository.SuperAdminRepository;
import com.clan.superAdmin.service.SuperAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping(path = "/v1/superAdmin",produces = MediaType.APPLICATION_JSON_VALUE)
public class SuperAdminController {

    private SuperAdminService superAdminService;

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<CreateSuperAdminResponse> addRegisterSuperAdmin(@RequestBody CreateSuperAdminRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(superAdminService.create(request));
        }
        catch (SuperAdminAlreadyExistingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        catch (DataNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
