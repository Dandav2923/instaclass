package com.clan.istituto.controller;

import com.clan.istituto.entity.Istituto;
import com.clan.istituto.repository.MateriaRepository;
import com.clan.istituto.service.IstitutoService;
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
    private IstitutoService istitutoService;

    @Autowired
    private MateriaRepository materiaRepository;


    @PostMapping(value = "/registerIstitute",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Istituto> addRegister(@RequestBody Istituto ist) {
        try {
            Istituto istituto = istitutoService.register(ist);
            return new ResponseEntity<Istituto>(istituto,HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<Istituto>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
