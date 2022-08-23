package com.clan.instaclass.classService.controllers.classNoteController;

import com.clan.instaclass.classService.exceptions.classNote.ClassNoteExistException;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteNotExistException;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteNotValidException;
import com.clan.instaclass.classService.models.classNote.*;
import com.clan.instaclass.classService.services.ClassNoteService;
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
@RequestMapping("v1/classNotes")
public class ClassNoteController {
    private final ClassNoteService classNoteService;

    @RequestMapping(
            path = "/getAllClassNotes/{idClass}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetClassNoteResponse>> getAllClassNotes(@PathVariable("idClass")Integer idClass){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(classNoteService.findAllClassNotes(idClass));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @RequestMapping(
            path = "/getAllByTeacher/{idClass}/{idTeacher}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetClassNoteResponse>> getAllClassNotesByTeacherId(@PathVariable("idClass")Integer idClass,@PathVariable("idTeacher")Integer idTeacher){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(classNoteService.findAllClassNotesTeacher(idClass,idTeacher));
        }
        catch (Exception e){
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
    private ResponseEntity<CreateClassNoteResponse> createClassNote(@RequestBody CreateClassNoteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(classNoteService.create(request));
        } catch (ClassNoteExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (ClassNoteNotValidException e) {
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
            path = "/updateClassNote",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutClassNoteResponse> updateClassNote(@RequestBody PutClassNoteRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(classNoteService.updateClassNoteTeacher(request));
        } catch (ClassNoteNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (ClassNoteNotValidException e) {
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
            path = "/deleteClassNote",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> deleteClassNote(@RequestBody DeleteClassNoteRequest request) {
        try {
            classNoteService.deleteClassNoteTeacher(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (ClassNoteNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (ClassNoteNotValidException e) {
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
