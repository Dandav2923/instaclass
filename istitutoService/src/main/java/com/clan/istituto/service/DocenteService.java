package com.clan.istituto.service;


import com.clan.DTO.DocenteDTO;
import com.clan.istituto.entity.Docente;
import com.clan.istituto.entity.Istituto;
import com.clan.istituto.entity.Materia;
import com.clan.istituto.exception.docente.CFNonCorrettoException;
import com.clan.istituto.exception.docente.DatiNonValidiException;
import com.clan.istituto.exception.docente.DocenteNonTrovatoException;
import com.clan.istituto.exception.docente.NumeroNonValidoException;
import com.clan.istituto.repository.DocenteRepository;
import com.clan.istituto.repository.IstitutoRepository;
import com.clan.istituto.repository.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private IstitutoRepository istitutoRepository;

    public List<Docente> getAll(Integer idIstitute) throws NumeroNonValidoException {
        if (idIstitute < 1) {
            throw new NumeroNonValidoException("numero inferiore a 1");
        }
        List<Docente> docenti = docenteRepository.getAllTeacherByIstitute(idIstitute);

        return docenti;
    }

    public Docente findTeacherByCF(String cf,Integer idIstituto) throws CFNonCorrettoException, DocenteNonTrovatoException {
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

    public Docente registerTeacher(DocenteDTO doc) throws DatiNonValidiException {
        if (doc.getCFTeacher() == null || doc.getNameTeacher() == null || doc.getSurnameTeacher() == null || doc.getPasswordTeacher() == null || doc.getIdIstitute() == null) {
            throw new DatiNonValidiException("mancano dei dati");
        } else {
            Istituto ist = istitutoRepository.findById(doc.getIdIstitute()).orElse(null);
            Materia mat = materiaRepository.findById(doc.getIdMateria()).orElse(null);
            if (ist == null || mat == null){
                throw new DatiNonValidiException("istituto o materia non trovati");
            }
            Docente registerDocente = new Docente();
            registerDocente.setCFTeacher(doc.getCFTeacher());
            registerDocente.setNameTeacher(doc.getNameTeacher());
            registerDocente.setSurnameTeacher(doc.getSurnameTeacher());
            registerDocente.setPasswordTeacher(doc.getPasswordTeacher());
            registerDocente.setTeacherIstitute(ist);
            registerDocente.getListTeacherMatter().add(mat);
            return docenteRepository.save(registerDocente);
        }
    }


}

