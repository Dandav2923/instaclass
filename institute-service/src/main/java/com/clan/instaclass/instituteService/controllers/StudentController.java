package com.clan.instaclass.instituteService.controllers;

import com.clan.instaclass.feign.instituteService.models.student.*;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.student.StudentAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.student.StudentNotFoundException;
import com.clan.instaclass.instituteService.models.student.*;
import com.clan.instaclass.instituteService.services.StudentService;
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
@CrossOrigin
@RequestMapping("/v1/students")
public class StudentController {

    private final StudentService studentService;


    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<CreateStudentResponse> createStudent(@RequestBody CreateStudentRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(request));
        }
        catch (StudentAlreadyExistingException e) {
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
            path = "/{idStudent}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetStudentResponse> get(@PathVariable("idStudent") Integer studentId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.get(studentId));
        }
        catch (StudentNotFoundException e) {
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
            path = "/getUsernameStudent",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetStudentResponse> getUsernameStudent(@RequestBody GetUsernameStudentRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getUsername(request));
        }
        catch (StudentNotFoundException e) {
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
            path = "/updateStudent",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutStudentResponse> updateStudent(@RequestBody PutStudentRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.put(request));
        }
        catch (StudentAlreadyExistingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        catch (StudentNotFoundException e) {
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
            path = "/getAllStudents/{idInstitute}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetStudentResponse>> getAll(@PathVariable("idInstitute") Integer idInstitute) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll(idInstitute));
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
            path = "/delete/{idStudent}",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> delete(@PathVariable("idStudent") Integer idStudent) {
        try {
            studentService.delete(idStudent);
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
