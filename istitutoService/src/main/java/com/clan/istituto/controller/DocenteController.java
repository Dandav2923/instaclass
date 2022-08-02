package com.clan.istituto.controller;

import com.clan.istituto.entity.Docente;
import com.clan.istituto.exception.docente.CFNonCorrettoException;
import com.clan.istituto.exception.docente.DatiNonValidiException;
import com.clan.istituto.exception.docente.DocenteNonTrovatoException;
import com.clan.istituto.repository.DocenteRepository;
import com.clan.istituto.service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.clan.DTO.DocenteDTO;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/docente",produces = MediaType.APPLICATION_JSON_VALUE)
public class DocenteController {


    @Autowired
    private DocenteService docenteService;

    @Autowired
    private DocenteRepository docenteRepository;

    @GetMapping("/getTeacher")
    public ResponseEntity<List<Docente>> getAllTeacher(){
        try {
            List<Docente> doc = docenteRepository.findAll();
            return new ResponseEntity<List<Docente>>(doc, HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<List<Docente>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCFTeacher/{cf}/{idIstituto}")
    public ResponseEntity<Docente> getCFTeacher(@PathVariable("cf") String codiceFis,@PathVariable("idIstituto") Integer idIst){
        try {
            return new ResponseEntity<Docente>(docenteService.findTeacherByCF(codiceFis,idIst), HttpStatus.OK);
        }
        catch (CFNonCorrettoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Docente>(HttpStatus.BAD_REQUEST);
        }
        catch (DocenteNonTrovatoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Docente>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Docente>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "",consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Docente> addRegister(@RequestBody DocenteDTO doc) {
        try {
            Docente addDocente = docenteService.registerTeacher(doc);
            return new ResponseEntity<Docente>(addDocente,HttpStatus.OK);
        }
        catch (DatiNonValidiException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Docente>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Docente>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @PutMapping(path = "/updateTeacher",consumes = "application/json")
    public ResponseEntity<Docente> aggiornamentoCompleto(@RequestBody Docente doc) {
        try {
            Docente docente = docenteRepository.findById(doc.getId()).orElse(null);
            docente.setNameTeacher(doc.getNameTeacher());
            docente.setSurnameTeacher(doc.getSurnameTeacher());
            docente.setCFTeacher(doc.getCFTeacher());
            docenteRepository.save(docente);
            return new ResponseEntity<Docente>(docente,HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Docente>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/deleteDocente/{cf}")
    public ResponseEntity<Void> deleteDoc(@PathVariable("cf") String codiceFis){
        try {
            Docente doc = docenteRepository.findBycFTeacher(codiceFis);
            int x = doc.getId();
            docenteRepository.deleteById(x);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     */

}
