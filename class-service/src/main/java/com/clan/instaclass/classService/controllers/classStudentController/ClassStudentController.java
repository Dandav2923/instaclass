package com.clan.instaclass.classService.controllers.classStudentController;

import com.clan.instaclass.classService.exceptions.classStudent.ClassStudentNotExistException;
import com.clan.instaclass.classService.exceptions.classStudent.ClassStudentNotValidException;
import com.clan.instaclass.classService.exceptions.classStudent.StudentAlreadyExistingException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.models.classStudent.*;
import com.clan.instaclass.classService.services.ClassStudentService;
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
@RequestMapping("/v1/classStudents")
public class ClassStudentController {
    private final ClassStudentService classStudentService;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<CreateClassStudentResponse> create(@RequestBody CreateClassStudentRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(classStudentService.create(request));
        }
        catch (ClassStudentNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (ClassNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (StudentAlreadyExistingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(
            path = "/{idClass}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetClassStudentResponse>> get(@PathVariable("idClass") Integer classId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(classStudentService.get(classId));
        }
        catch (ClassStudentNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (ClassNotExistException e) {
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
            path = "/updateClassStudent",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutClassStudentResponse> put(@RequestBody PutClassStudentRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(classStudentService.put(request));
        }
        catch (ClassStudentNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch (ClassNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (ClassStudentNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch (StudentAlreadyExistingException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @RequestMapping(
            path = "/deleteClassStudent",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<Void> deleteClassStudent(@RequestBody DeleteClassStudentRequest request){
        try{
            classStudentService.deleteClassStudent(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (ClassStudentNotExistException | StudentAlreadyExistingException | ClassNotExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
