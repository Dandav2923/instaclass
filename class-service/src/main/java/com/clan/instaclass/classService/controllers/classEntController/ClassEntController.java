package com.clan.instaclass.classService.controllers.classEntController;

import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotValidException;
import com.clan.instaclass.classService.models.classes.*;
import com.clan.instaclass.classService.services.ClassService;
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
@RequestMapping("v1/classes")
public class ClassEntController {

    private final ClassService classService;

    @RequestMapping(
            //modificare path e nome variabile per essere chiaro idInstitute
            path = "/getAll/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetClassResponse>> get(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(classService.findAll(id));
        } catch (Exception e) {
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
            return ResponseEntity.status(HttpStatus.CREATED).body(classService.create(request));
        } catch (ClassExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (ClassNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(
            path = "/updateClass",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutClassResponse> updateClass(@RequestBody PutClassRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(classService.updateClass(request));
        } catch (ClassNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (ClassNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(
            path = "/deleteClass",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> deleteClass(@RequestBody DeleteClassRequest request) {
        try {
            classService.deleteClass(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (ClassNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (ClassNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}