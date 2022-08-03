package com.clan.instaclass.instituteService.controllers;

import com.clan.instaclass.instituteService.exceptions.InstituteNotFoundException;
import com.clan.instaclass.instituteService.models.institute.CreateInstituteRequest;
import com.clan.instaclass.instituteService.models.institute.CreateInstituteResponse;
import com.clan.instaclass.instituteService.models.institute.GetInstituteResponse;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(instituteService.create(request));
    }

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetInstituteResponse> create(@PathVariable("id") Integer instituteId) throws InstituteNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(instituteService.get(instituteId));
    }
}
