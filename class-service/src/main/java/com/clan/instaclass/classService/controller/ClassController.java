package com.clan.instaclass.classService.controller;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.models.classes.CreateClassRequest;
import com.clan.instaclass.classService.models.classes.CreateClassResponse;
import com.clan.instaclass.classService.repositories.ClassRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
@Slf4j
@RestController
@RequestMapping("v1/classes")
public class ClassController {

    @Autowired
    private ClassRepository classRepository;

    @RequestMapping(
            path = "/get",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<ClassEnt>> get() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(classRepository.findAll());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<CreateClassResponse> create(@RequestBody CreateClassRequest request) {
        try {
            ClassEnt entity = new ClassEnt();
            entity.setName(request.getName());
            entity.setInstitute(request.getIdInstitute());
            CreateClassResponse response = new CreateClassResponse();
            response.setName(classRepository.save(entity).getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
