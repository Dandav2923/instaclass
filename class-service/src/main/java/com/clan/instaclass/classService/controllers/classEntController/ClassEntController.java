package com.clan.instaclass.classService.controllers.classEntController;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotValidException;
import com.clan.instaclass.classService.models.classes.CreateClassRequest;
import com.clan.instaclass.classService.models.classes.CreateClassResponse;
import com.clan.instaclass.classService.models.classes.GetClassResponse;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.services.ClassService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
            path = "/getAll/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetClassResponse>> get(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(classService.findAll(id));
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
            return ResponseEntity.status(HttpStatus.CREATED).body(classService.create(request));
        }
        catch (ClassExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        catch (ClassNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}