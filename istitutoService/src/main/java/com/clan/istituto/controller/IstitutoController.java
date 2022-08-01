package com.clan.istituto.controller;

import com.clan.istituto.entity.Istituto;
import com.clan.istituto.entity.Materia;
import com.clan.istituto.repository.IstitutoRepository;
import com.clan.istituto.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/istituto",produces = MediaType.APPLICATION_JSON_VALUE)
public class IstitutoController {

    @Autowired
    private IstitutoRepository istitutoRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @GetMapping("/getIstitute")
    public ResponseEntity<List<Istituto>> getIstitutes(){
        try {
            return new ResponseEntity<List<Istituto>>(istitutoRepository.findAll() , HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<List<Istituto>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/registerIstituteMatter/{id}")
    public ResponseEntity<Void> addRegister(@PathVariable("id") Integer id) {
        try {
            Materia mat = materiaRepository.findById(id).orElse(null);
            Istituto ist = istitutoRepository.findById(1).orElse(null);
            ist.getListIstituteMatter().add(mat);
            istitutoRepository.save(ist);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }

    }

}
