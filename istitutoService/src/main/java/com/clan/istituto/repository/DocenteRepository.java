package com.clan.istituto.repository;

import com.clan.istituto.entity.Docente;
import com.clan.istituto.entity.Istituto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocenteRepository extends JpaRepository<Docente,Integer> {

    @Query("SELECT d FROM Docente d JOIN d.teacherIstitute t WHERE t.id = :int")
    public List<Docente> getAllTeacherByIstitute(@Param("int") Integer ist);


    @Query("SELECT d FROM Docente d WHERE d.cFTeacher = :cf AND d.teacherIstitute = :id")
    public List<Docente> findByNameTeacher(@Param("cf") String codiceFiscale, @Param("id") Integer idIstituto);

    public Docente findBycFTeacher(String cf);


}
