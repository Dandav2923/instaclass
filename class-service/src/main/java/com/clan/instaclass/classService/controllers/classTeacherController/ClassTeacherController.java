package com.clan.instaclass.classService.controllers.classTeacherController;

import com.clan.instaclass.classService.exceptions.classTeacher.ClassTeacherExistException;
import com.clan.instaclass.classService.exceptions.classTeacher.ClassTeacherNotExistException;
import com.clan.instaclass.classService.exceptions.classTeacher.ClassTeacherNotValidException;
import com.clan.instaclass.classService.models.classTeacher.*;
import com.clan.instaclass.classService.services.ClassTeacherService;
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
@RequestMapping("v1/classTeachers")
public class ClassTeacherController {
    private final ClassTeacherService classTeacherService;
    @RequestMapping(
            path = "/getAllClassTeacher/{idClass}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetClassTeacherResponse>> getAllClassTeachersByClassId(@PathVariable("idClass")Integer idClass){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(classTeacherService.findAllTeacherByClass(idClass));
        }catch (Exception e){
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
    private ResponseEntity<CreateClassTeacherResponse> createClassTeacher(@RequestBody CreateClassTeacherRequest request){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(classTeacherService.create(request));
        }catch (ClassTeacherNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }catch (ClassTeacherExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @RequestMapping(
            path = "/updateClassTeacher",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutClassTeacherResponse> updateClassTeacher(@RequestBody PutClassTeacherRequest request){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(classTeacherService.updateClassTeacher(request));
        }catch (ClassTeacherNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }catch (ClassTeacherNotExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @RequestMapping(
            path = "/deleteClassTeacher",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> deleteClassTeacher(@RequestBody DeleteClassTeacherRequest request){
        try {
            classTeacherService.deleteClassTeacher(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (ClassTeacherNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }catch (ClassTeacherNotExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
