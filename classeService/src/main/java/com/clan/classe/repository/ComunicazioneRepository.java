package com.clan.classe.repository;

import com.clan.classe.entity.Compito;
import com.clan.classe.entity.Comunicazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ComunicazioneRepository extends JpaRepository<Comunicazione,Integer> {
    public List<Comunicazione> findByDataComunicazione(LocalDate dataComunicazione);
    public List<Comunicazione> findByDataComunicazioneContains(LocalDate dataComunicazione);
    public List<Comunicazione> findByNomeComunicazione(String nomeComunicazione);
    public List<Comunicazione> findByNomeComunicazioneContains(String nomeComunicazione);

    @Query("select comunicazione from Comunicazione comunicazione where comunicazione.comunicazioneClasse=:idClasse")
    public List<Comunicazione> getAllByIdClass(@Param("idClasse") Integer idClasse);
}
