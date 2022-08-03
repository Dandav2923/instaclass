package com.clan.instaclass.instituteService.repositories;

import com.clan.instaclass.instituteService.entities.StudentEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEnt, Integer> {
}
