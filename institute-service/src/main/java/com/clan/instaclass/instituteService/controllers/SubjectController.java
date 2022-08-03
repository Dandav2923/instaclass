package com.clan.instaclass.instituteService.controllers;

import com.clan.instaclass.instituteService.exceptions.subject.SubjectNotFoundException;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectRequest;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectResponse;
import com.clan.instaclass.instituteService.models.subject.GetSubjectResponse;
import com.clan.instaclass.instituteService.services.SubjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/v1/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<CreateSubjectResponse> create(@RequestBody CreateSubjectRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(subjectService.create(request));
    }

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetSubjectResponse> create(@PathVariable("id") Integer subjectId) throws SubjectNotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(subjectService.get(subjectId));
    }
}
