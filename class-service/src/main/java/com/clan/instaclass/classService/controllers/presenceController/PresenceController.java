package com.clan.instaclass.classService.controllers.presenceController;

import com.clan.instaclass.classService.exceptions.classNote.ClassNoteExistException;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteNotExistException;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteNotValidException;
import com.clan.instaclass.classService.exceptions.presence.PresenceExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceNotExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceNotValidException;
import com.clan.instaclass.classService.models.classNote.*;
import com.clan.instaclass.classService.models.presence.*;
import com.clan.instaclass.classService.services.PresenceService;
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
@RequestMapping("v1/presences")
public class PresenceController {
    private final PresenceService presenceService;
    @RequestMapping(
            path = "/getAll/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetPresenceResponse>> getAllPresences(@PathVariable("id")Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenceService.findAllPresences(id));
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @RequestMapping(
            path = "/getAllByStudent/{idClass}/{idStudent}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetPresenceResponse>> getAllPresencesByStudent(@PathVariable("idClass")Integer idClass,@PathVariable("idStudent")Integer idStudent){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(presenceService.findAllPresencesByStudent(idClass,idStudent));
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
    private ResponseEntity<CreatePresenceResponse> createPresence(@RequestBody CreatePresenceRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(presenceService.create(request));
        } catch (PresenceNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (PresenceExistException e) {
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
            path = "/updatePresence",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutPresenceResponse> updatePresence(@RequestBody PutPresenceRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(presenceService.updatePresence(request));
        } catch (PresenceNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (PresenceNotValidException e) {
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
            path = "/deletePresence",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> deletePresence(@RequestBody DeletePresenceRequest request) {
        try {
            presenceService.deletePresence(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (PresenceNotExistException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } catch (PresenceNotValidException e) {
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
