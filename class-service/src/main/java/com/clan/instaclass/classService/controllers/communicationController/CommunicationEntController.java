package com.clan.instaclass.classService.controllers.communicationController;

import com.clan.instaclass.classService.exceptions.communication.CommunicationExistException;
import com.clan.instaclass.classService.exceptions.communication.CommunicationNotExistException;
import com.clan.instaclass.classService.exceptions.communication.CommunicationNotValidException;
import com.clan.instaclass.classService.models.communication.*;
import com.clan.instaclass.classService.services.CommunicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("v1/communications")
public class CommunicationEntController {
    private final CommunicationService communicationService;

    @RequestMapping(
            path = "/getAll/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetCommunicationResponse>> getAll(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(communicationService.findAllCommunications(id));
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
    private ResponseEntity<CreateCommunicationResponse> createCommunication(@RequestBody CreateCommunicationRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(communicationService.create(request));
        }catch(CommunicationNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(CommunicationExistException e){
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
            path = "/updateCommunication",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutCommunicationResponse> updateCommunication(@RequestBody PutCommunicationRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(communicationService.updateCommunication(request));
        }catch(CommunicationNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(CommunicationNotExistException e){
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
            path = "/deleteCommunication",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> deleteCommunication(@RequestBody DeleteCommunicationRequest request){
        try {
            communicationService.deleteCommunication(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch(CommunicationNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(CommunicationNotExistException e){
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
}
