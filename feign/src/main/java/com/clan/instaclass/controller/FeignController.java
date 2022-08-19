package com.clan.instaclass.controller;

import com.clan.instaclass.institute.FeignInstitute;
import com.clan.instaclass.models.institute.GetInstituteResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping
public class FeignController {

    private FeignInstitute feignInstitute;

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetInstituteResponseDTO> get(@PathVariable("id") Integer instituteId) {
        try {
           return ResponseEntity.status(HttpStatus.OK).body(feignInstitute.get(instituteId));
        } catch(Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
    }
}
