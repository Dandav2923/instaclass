package com.clan.instaclass.classService.controllers.classEntController;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotValidException;
import com.clan.instaclass.classService.services.impl.ClassServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/classes", produces = MediaType.APPLICATION_JSON_VALUE)
public class classEntController {
    @Autowired
    private ClassServiceImpl classService;

    @PostMapping(value = "/createNewClass", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClassEnt> createNewClass(@RequestBody ClassEnt classEnt){
        try {
            ClassEnt newClass = classService.createNewClass(classEnt);
            return new ResponseEntity<ClassEnt>(newClass, HttpStatus.CREATED);
        } catch (ClassExistException | ClassNotValidException e) {
            e.printStackTrace();
            return new ResponseEntity<ClassEnt>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<ClassEnt>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/getAllClasses")
    public ResponseEntity<List<ClassEnt>> getAllClasses(){
        try {
            List<ClassEnt> classResult = classService.findAllClasses();
            if (classResult.size() > 0) {
                return new ResponseEntity<List<ClassEnt>>(classResult, HttpStatus.OK);
            }
            return new ResponseEntity<List<ClassEnt>>(HttpStatus.NOT_FOUND);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<List<ClassEnt>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
