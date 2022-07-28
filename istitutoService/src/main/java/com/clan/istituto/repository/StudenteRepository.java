package com.clan.istituto.repository;

import com.clan.istituto.entity.Studente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente,Integer> {
}
