package com.clan.classe.restController;

import com.clan.classe.entity.Classe;
import com.clan.classe.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/classes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClasseRestController {
    @Autowired
    private ClasseService classeService;

    // metodo che espone il servizio per ricevere tutte le classe del db
    @GetMapping("/getAllClasses")
    public ResponseEntity<List<Classe>> getAllClasses() {
        try {
            List<Classe> classResult = classeService.findAllClasses();
            if (classResult.size() > 0) {
                return new ResponseEntity<List<Classe>>(classResult, HttpStatus.OK);
            }
            return new ResponseEntity<List<Classe>>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<List<Classe>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // metodo che espone il servizio per ricevere una classe in base all'id inserito
    @GetMapping("/getClassById/{id}")
    public ResponseEntity<Classe> getAllClasses(@PathVariable("id") Integer id) {
        try {
            Classe classResult = classeService.findById(id);
            HttpStatus status = classResult != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
            return new ResponseEntity<Classe>(classResult, status);
        } catch (Exception e) {
            return new ResponseEntity<Classe>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // metodo che espone il servizio per ricevere una classe in base al nome in base all'istituto
    @GetMapping("/getClassByName/{id}/{name}")
    public ResponseEntity<List<Classe>> getClassesByName(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        try {
            List<Classe> classList = classeService.findByClassNameContains(id, name);
            HttpStatus status = classList != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
            return new ResponseEntity<List<Classe>>(classList, status);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Classe>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //metodo che espone il servizio per creare una nuova classe
    @PostMapping(path = "/createClass",consumes = "application/json")
    public ResponseEntity<Classe> createClass(@RequestBody Classe classe){
        try {
            Classe newClass = classeService.createNewClass(classe);
            return new ResponseEntity<Classe>(newClass, HttpStatus.CREATED);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Classe>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //metodo che espone il servizio per modificare una classe
    @PutMapping(path = "/updateClass", consumes = "application/json")
    public ResponseEntity<Classe> updateClass(@RequestBody Classe classe){
        try {
            Classe newClass = classeService.fullyClassUpdate(classe);
            return new ResponseEntity<Classe>(newClass, HttpStatus.OK);
        }
        catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity<Classe>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //metodo per cancellare una classe per id
    @DeleteMapping(path = "/deleteById/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        try {
            classeService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //metodo per cancellare una classe per nome di un istituto specifico
    @DeleteMapping(path = "/deleteById/{id}/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByClassName(@PathVariable("id")Integer id, @PathVariable("name")String name){
        if (id == null && name == "" || name == null){
            System.out.println("Non hai fornito le informazioni necessarie per la cancellazione");
        }
        classeService.deleteByClassName(id, name);
    }
}
