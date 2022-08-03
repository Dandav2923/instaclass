package com.clan.instaclass.instituteService.repositories;

import com.clan.instaclass.instituteService.entities.TeacherEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEnt, Integer> {
}