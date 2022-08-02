package com.clan.classe.repository;

import com.clan.classe.entity.Comunicazione;
import com.clan.classe.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface NotaRepository extends JpaRepository<Nota,Integer> {
    //public List<Nota> findByDataNota(LocalDate dataNota);
    //public List<Nota> findByDataNotaContains(LocalDate dataNota);
    //@Query("select nota from Nota nota where nota.cfStudente=:codiceFiscaleStudente")
    //public List<Nota> findNotaStudenteByCf(@Param("codiceFiscaleStudente") String codiceFiscaleStudente);

    //@Query("select nota from Nota nota where nota.notaClasse=:idClasse")
    //public List<Nota> getAllByIdClass(@Param("idClasse") Integer idClasse);

}
