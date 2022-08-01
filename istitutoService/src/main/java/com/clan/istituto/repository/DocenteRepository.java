package com.clan.istituto.repository;

import com.clan.istituto.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocenteRepository extends JpaRepository<Docente,Integer> {

    public List<Docente> findByNameTeacher(String nome);

    public Docente findBycFTeacher(String cf);


}
