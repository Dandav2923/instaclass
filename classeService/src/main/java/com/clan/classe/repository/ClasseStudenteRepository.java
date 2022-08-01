package com.clan.classe.repository;

import com.clan.classe.entity.ClasseDocente;
import com.clan.classe.entity.ClasseStudente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClasseStudenteRepository extends JpaRepository<ClasseStudente,Integer> {
    @Query("select classeStudente from ClasseStudente classeStudente where classeStudente.studenteFK = :idStudente")
    public List<ClasseStudente> getAllByIdStudente (@Param("idStudente") Integer id);
}
