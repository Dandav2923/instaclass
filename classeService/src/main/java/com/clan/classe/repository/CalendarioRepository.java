package com.clan.classe.repository;

import com.clan.classe.entity.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CalendarioRepository extends JpaRepository<Calendario,Integer> {
    //public List<Calendario> findByDataEvento(LocalDate dataEvento);
    //public List<Calendario> findByDataEventoContains(LocalDate dataEvento);
    //public List<Calendario> findByNomeEvento(String nomeEvento);
    //public List<Calendario> findByNomeEventoContains(String nomeEvento);
    //@Query("select calendario from Calendario calendario where calendario.calendarioClasse=:idClasse")
    //public Calendario getAllByIdClass(@Param("idClasse") Integer idClasse);


}
