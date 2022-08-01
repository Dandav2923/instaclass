package com.clan.istituto.repository;

import com.clan.istituto.entity.Materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia,Integer> {





}
