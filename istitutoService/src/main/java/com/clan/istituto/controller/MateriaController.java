package com.clan.istituto.controller;

import com.clan.DTO.DocenteDTO;
import com.clan.DTO.MateriaDTO;
import com.clan.istituto.entity.Docente;
import com.clan.istituto.entity.Materia;
import com.clan.istituto.exception.docente.CFNonCorrettoException;
import com.clan.istituto.exception.docente.DatiNonValidiException;
import com.clan.istituto.exception.docente.DocenteNonTrovatoException;
import com.clan.istituto.exception.docente.MateriaNonTrovataException;
import com.clan.istituto.repository.MateriaRepository;
import com.clan.istituto.service.MateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/matter",produces = MediaType.APPLICATION_JSON_VALUE)
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

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

    @PostMapping(path = "",consumes = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Materia> registerMateria(@RequestBody MateriaDTO mat) {
        try {
            Materia registerMateria = materiaService.registerMatter(mat);
            return new ResponseEntity<Materia>(registerMateria,HttpStatus.OK);
        }
        catch (MateriaNonTrovataException e) {
            e.printStackTrace();
            return new ResponseEntity<Materia>(HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Materia>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    @GetMapping("/getMatter")
    public ResponseEntity<List<Materia>> getMatter(){
        try {
            return new ResponseEntity<List<Materia>>(materiaRepository.findAll(),HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return new ResponseEntity<List<Materia>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
     */

}
