package com.clan.instaclass.instituteService.controllers;

import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.institute.AlreadyExistingIstituteException;
import com.clan.instaclass.instituteService.exceptions.institute.InstituteNotFoundException;
import com.clan.instaclass.instituteService.exceptions.teacher.TeacherAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.teacher.TeacherNotFoundException;
import com.clan.instaclass.instituteService.models.institute.*;
import com.clan.instaclass.instituteService.models.teacher.*;
import com.clan.instaclass.instituteService.services.InstituteService;
import com.clan.instaclass.instituteService.services.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;


    @RequestMapping(
            path = "/connect",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<Void> TeacherSubjectConnect(@RequestBody ConnectTeacherSubjectRequest request) {
        try {
            teacherService.teacherSubjectConnect(request);
            return new ResponseEntity<Void>(HttpStatus.CREATED);

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
    private ResponseEntity<CreateTeacherResponse> create(@RequestBody CreateTeacherRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.create(request));
        }
        catch (TeacherNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (TeacherAlreadyExistingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        catch (DataNonValidException e) {
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

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetTeacherResponse> get(@PathVariable("id") Integer instituteId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(teacherService.get(instituteId));
        }
        catch (TeacherNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(
            path = "/getUsername",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetTeacherResponse> getUsername(@RequestBody GetUsernameTeacherRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(teacherService.getUsername(request));
        }
        catch (TeacherNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }



    @RequestMapping(
            path = "/update",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutTeacherResponse> put(@RequestBody PutTeacherRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(teacherService.put(request));
        }
        catch (TeacherAlreadyExistingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        catch (TeacherNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (DataNonValidException e) {
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


    @RequestMapping(
            path = "/delete/{id}",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        try {
            teacherService.delete(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch (DataNonValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
