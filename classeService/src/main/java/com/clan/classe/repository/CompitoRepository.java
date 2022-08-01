package com.clan.classe.repository;

import com.clan.classe.entity.Calendario;
import com.clan.classe.entity.Compito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CompitoRepository extends JpaRepository<Compito,Integer> {
    public List<Compito> findByDataConsegna(LocalDate dataConsegna);
    public List<Compito> findByDataConsegnaContains(LocalDate dataConsegna);

    @Query("select compito from Compito compito where compito.compitoClasse=:idClasse")
    public List<Compito> getAllByIdClass(@Param("idClasse") Integer idClasse);
}
