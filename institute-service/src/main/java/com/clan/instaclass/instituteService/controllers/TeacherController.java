package com.clan.instaclass.instituteService.controllers;

import com.clan.instaclass.feign.instituteService.models.teacher.*;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectNotFoundException;
import com.clan.instaclass.instituteService.exceptions.teacher.TeacherAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.teacher.TeacherNotFoundException;
import com.clan.instaclass.feign.instituteService.models.subject.GetSubjectResponse;
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
            path = "/connectTeacherSubject",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<Void> TeacherSubjectConnect(@RequestBody ConnectTeacherSubjectRequest request) {
        try {
            teacherService.teacherSubjectConnect(request);
            return new ResponseEntity<Void>(HttpStatus.CREATED);

        }
        catch (TeacherNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (SubjectNotFoundException e) {
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
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<CreateTeacherResponse> create(@RequestBody CreateTeacherRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.create(request));
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
            path = "/{idTeacher}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetTeacherResponse> get(@PathVariable("idTeacher") Integer idTeacher) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(teacherService.get(idTeacher));
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
            path = "/getAllTeachers/{idInstitute}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetTeacherResponse>> getAllTeachersByIdInstitute(@PathVariable("idInstitute") Integer instituteId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(teacherService.getAll(instituteId));
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
            path = "/getSubjects/{idTeacher}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetSubjectResponse>> getSubject(@PathVariable("idTeacher") Integer teacherId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(teacherService.getSubjects(teacherId));
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
            path = "/getUsernameTeacher",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetTeacherResponse> getUsernameTeacher(@RequestBody GetUsernameTeacherRequest request) {
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
            path = "/updateTeacher",
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
            path = "/delete/{idTeacher}",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> deleteTeacher(@PathVariable("idTeacher") Integer idTeacher) {
        try {
            teacherService.delete(idTeacher);
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
