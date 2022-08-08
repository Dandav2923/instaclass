package com.clan.instaclass.classService.controllers.homeworkController;

import com.clan.instaclass.classService.exceptions.event.EventExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotValidException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkNotExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkNotValidException;
import com.clan.instaclass.classService.models.event.*;
import com.clan.instaclass.classService.models.homework.*;
import com.clan.instaclass.classService.services.HomeworkService;
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
@RequestMapping("v1/homeworks")
public class HomeworkController {
    private final HomeworkService homeworkService;

    @RequestMapping(
            path = "/getAll/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<List<GetHomeworkResponse>> getAll(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(homeworkService.findAllHomeworks(id));
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
    private ResponseEntity<CreateHomeworkResponse> createHomework(@RequestBody CreateHomeworkRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(homeworkService.create(request));
        }catch(HomeworkNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(HomeworkExistException e){
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
            path = "/updateHomework",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    private ResponseEntity<PutHomeworkResponse> updateHomework(@RequestBody PutHomeworkRequest request){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(homeworkService.updateHomework(request));
        }catch(HomeworkNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(HomeworkNotExistException e){
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
            path = "/deleteHomework",
            method = RequestMethod.DELETE
    )
    private ResponseEntity<Void> deleteHomework(@RequestBody DeleteHomeworkRequest request){
        try {
            homeworkService.deleteHomework(request);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch(HomeworkNotValidException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        catch(HomeworkNotExistException e){
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
