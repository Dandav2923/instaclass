package com.clan.instaclass.instituteService.repositories;

import com.clan.instaclass.instituteService.entities.SubjectEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEnt, Integer> {
}
