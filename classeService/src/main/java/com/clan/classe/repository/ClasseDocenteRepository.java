package com.clan.classe.repository;

import com.clan.classe.entity.Classe;
import com.clan.classe.entity.ClasseDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClasseDocenteRepository extends JpaRepository<ClasseDocente,Integer> {
    @Query("select classeDocente from ClasseDocente classeDocente where classeDocente.docenteFK = :idDocente")
    public List<ClasseDocente> getAllByIdDocente (@Param("idDocente") Integer id);
}
