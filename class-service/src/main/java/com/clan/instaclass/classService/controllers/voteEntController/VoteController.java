package com.clan.instaclass.classService.controllers.voteEntController;

import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkNotExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkNotValidException;
import com.clan.instaclass.classService.exceptions.vote.VoteNotExistException;
import com.clan.instaclass.classService.exceptions.vote.VoteNotValidException;
import com.clan.instaclass.classService.models.homework.*;
import com.clan.instaclass.classService.models.vote.*;
import com.clan.instaclass.classService.services.HomeworkService;
import com.clan.instaclass.classService.services.VoteService;
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
@RequestMapping("v1/votes")
public class VoteController {

    private final VoteService voteService;

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<CreateVoteResponse> create(@RequestBody CreateVoteRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(voteService.create(request));
        }
        catch(VoteNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(ClassNotExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @RequestMapping(
            path = "/getAllVoteStudent/{idStudent}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetAllVoteResponse>> getAllVoteStudent(@PathVariable("idStudent") Integer idStudent){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(voteService.getAllVoteStudent(idStudent));
        }
        catch(VoteNotValidException e){
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

    @RequestMapping(
            path = "/getAllVoteClass/{idClass}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetAllVoteResponse>> getAllVoteClass(@PathVariable("idClass") Integer idClass){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(voteService.getAllVoteClass(idClass));
        }
        catch(VoteNotValidException e){
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

    @RequestMapping(
            path = "/getAllVoteTeacher/{idTeacher}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetAllVoteResponse>> getAllVoteTeacher(@PathVariable("idTeacher") Integer idTeacher){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(voteService.getAllVoteTeacher(idTeacher));
        }
        catch(VoteNotValidException e){
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


    @RequestMapping(
            path = "/updateVote",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutVoteResponse> updateHomework(@RequestBody PutVoteRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(voteService.update(request));
        }catch(VoteNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(VoteNotExistException e){
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
            path = "/getById/{idVote}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<GetVoteResponse> getVote(@PathVariable("idVote") Integer idVote){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(voteService.getVote(idVote));
        }
        catch(VoteNotExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch(VoteNotValidException e){
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


    @RequestMapping(
            path = "/deleteVote/{idVote}",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> delete(@PathVariable("idVote") Integer idVote){
        try {
            voteService.delete(idVote);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch(VoteNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(VoteNotExistException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
