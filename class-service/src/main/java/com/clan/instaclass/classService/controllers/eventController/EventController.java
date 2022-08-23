package com.clan.instaclass.classService.controllers.eventController;

import com.clan.instaclass.classService.exceptions.communication.CommunicationExistException;
import com.clan.instaclass.classService.exceptions.communication.CommunicationNotValidException;
import com.clan.instaclass.classService.exceptions.event.EventExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotValidException;
import com.clan.instaclass.classService.models.communication.CreateCommunicationRequest;
import com.clan.instaclass.classService.models.communication.CreateCommunicationResponse;
import com.clan.instaclass.classService.models.communication.GetCommunicationResponse;
import com.clan.instaclass.classService.models.communication.PutCommunicationResponse;
import com.clan.instaclass.classService.models.event.*;
import com.clan.instaclass.classService.services.EventService;
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
@RequestMapping("v1/events")
public class EventController {
    private final EventService eventService;

    @RequestMapping(
            path = "/getAllEvents/{idClass}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetEventResponse>> getAll(@PathVariable("idClass") Integer idClass){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventService.findAllEvents(idClass));
        }catch(Exception e){
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
    private ResponseEntity<CreateEventResponse> createEvent(@RequestBody CreateEventRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventService.create(request));
        }catch(EventNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(EventExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(
            path = "/updateEvent",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutEventResponse> updateEvent(@RequestBody PutEventRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(eventService.updateEvent(request));
        }catch(EventNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(EventNotExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @RequestMapping(
            path = "/deleteEvent",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> deleteEvent(@RequestBody DeleteEventRequest request){
        try {
            eventService.deleteEvent(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch(EventNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(EventNotExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
