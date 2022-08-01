package com.clan.istituto.controller;

import com.clan.istituto.entity.Docente;
import com.clan.istituto.entity.Materia;
import com.clan.istituto.exception.docente.CFNonCorrettoException;
import com.clan.istituto.exception.docente.DocenteNonTrovatoException;
import com.clan.istituto.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/matter",produces = MediaType.APPLICATION_JSON_VALUE)
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;

    /*
    @GetMapping("/getMatterByIstitute/{ist}")
    public ResponseEntity<List<Materia>> getMatterByIst(@PathVariable("ist") Integer istInt){
        try {
            return new ResponseEntity<List<Materia>>(materiaRepository.findMaterieByIstitute(istInt), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<List<Materia>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     */
}
