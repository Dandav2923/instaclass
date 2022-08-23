package com.clan.instaclass.classService.controllers.studentNoteController;

import com.clan.instaclass.classService.exceptions.presence.PresenceExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceNotExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceNotValidException;
import com.clan.instaclass.classService.exceptions.studentNote.StudentNoteExistException;
import com.clan.instaclass.classService.exceptions.studentNote.StudentNoteNotExistException;
import com.clan.instaclass.classService.exceptions.studentNote.StudentNoteNotValidException;
import com.clan.instaclass.classService.models.presence.*;
import com.clan.instaclass.classService.models.studentNote.*;
import com.clan.instaclass.classService.services.StudentNoteService;
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
@RequestMapping("v1/studentNotes")
public class StudentNoteController {
    private final StudentNoteService studentNoteService;
    @RequestMapping(
            path = "/getAllStudentNotes/{idClass}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetStudentNoteResponse>> getAllStudentNotes(@PathVariable("idClass")Integer idClass){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentNoteService.findAllStudentNotes(idClass));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @RequestMapping(
            path = "/getAllNotesByStudent/{idClass}/{idStudent}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetStudentNoteResponse>> getAllStudentNotesByStudent(@PathVariable("idClass")Integer idClass, @PathVariable("idStudent")Integer idStudent){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentNoteService.findAllStudentNotesByIdStudent(idClass,idStudent));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @RequestMapping(
            path = "/getAllNotesByTeacher/{idClass}/{idTeacher}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetStudentNoteResponse>> getAllStudentNotesByTeacher(@PathVariable("idClass")Integer idClass, @PathVariable("idTeacher")Integer idTeacher){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentNoteService.findAllStudentNotesByIdTeacher(idClass,idTeacher));
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
    private ResponseEntity<CreateStudentNoteResponse> createStudentNote(@RequestBody CreateStudentNoteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentNoteService.create(request));
        } catch (StudentNoteNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (StudentNoteExistException e) {
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
            path = "/updateStudentNote",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutStudentNoteResponse> updateStudentNote(@RequestBody PutStudentNoteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(studentNoteService.updateStudentNote(request));
        } catch (StudentNoteNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (StudentNoteNotValidException e) {
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
            path = "/deleteStudentNote",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> deleteStudentNote(@RequestBody DeleteStudentNoteRequest request) {
        try {
            studentNoteService.deleteStudentNote(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (StudentNoteNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (StudentNoteNotValidException e) {
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
