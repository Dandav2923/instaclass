package com.clan.instaclass.instituteService.controllers;

import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.institute.AlreadyExistingIstituteException;
import com.clan.instaclass.instituteService.exceptions.institute.InstituteNotFoundException;
import com.clan.instaclass.instituteService.models.institute.*;
import com.clan.instaclass.instituteService.services.InstituteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/institutes")
public class InstituteController {
    private final InstituteService instituteService;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<CreateInstituteResponse> create(@RequestBody CreateInstituteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(instituteService.create(request));
        }
        catch (AlreadyExistingIstituteException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
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
    private ResponseEntity<GetInstituteResponse> get(@PathVariable("id") Integer instituteId) throws InstituteNotFoundException {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instituteService.get(instituteId));
        }
        catch (InstituteNotFoundException e) {
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
    private ResponseEntity<PutInstituteResponse> put(@RequestBody PutInstituteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(instituteService.put(request));
        }
        catch (InstituteNotFoundException e) {
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
            instituteService.delete(id);
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
