package com.clan.istituto.controller;

import com.clan.istituto.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/matter",produces = MediaType.APPLICATION_JSON_VALUE)
public class MateriaController {

    @Autowired
    private MateriaRepository materiaRepository;



}
