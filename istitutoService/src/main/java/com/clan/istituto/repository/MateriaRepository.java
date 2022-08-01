package com.clan.istituto.repository;

import com.clan.istituto.entity.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia,Integer> {

    @Query(value = "select id_materia,nome_materia from schema_istituto.materie\n" +
            "JOIN schema_istituto.istituti_materie ON\n" +
            "schema_istituto.materie.id_materia = schema_istituto.istituti_materie.materia_fk\n" +
            "JOIN schema_istituto.istituti ON\n" +
            "schema_istituto.istituti_materie.istituto_fk = schema_istituto.istituti.id_istituto\n" +
            "WHERE schema_istituto.istituti.id_istituto = :idIstituto", nativeQuery = true)
    public List<Materia> findMaterieByIstitute(@Param("idIstituto") Integer idIstituto);

}
