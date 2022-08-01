package com.clan.istituto.service;


import com.clan.istituto.entity.Docente;
import com.clan.istituto.exception.docente.CFNonCorrettoException;
import com.clan.istituto.exception.docente.DatiNonValidiException;
import com.clan.istituto.exception.docente.DocenteNonTrovatoException;
import com.clan.istituto.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> getAll()  {
            return docenteRepository.findAll();
    }

    public Docente findTeacherByCF(String cf) throws CFNonCorrettoException, DocenteNonTrovatoException {

            if (cf == null || (cf.length() < 16 || cf.length() > 16 )) {
                throw new CFNonCorrettoException("codice Fiscale non corretto");
            }else{
               Docente doc = docenteRepository.findBycFTeacher(cf);
               if (doc == null){
                   throw new DocenteNonTrovatoException("docente non trovato");
               }
               else{
                   return doc;
               }
            }
    }

    public Docente registerTeacher(Docente doc) throws DatiNonValidiException {
        if (doc.getCFTeacher() == null || doc.getNameTeacher() == null || doc.getSurnameTeacher() == null || doc.getPasswordTeacher() == null) {
            throw new DatiNonValidiException("mancano dei dati");
        } else {

            return docenteRepository.save(doc);
        }
    }


}

