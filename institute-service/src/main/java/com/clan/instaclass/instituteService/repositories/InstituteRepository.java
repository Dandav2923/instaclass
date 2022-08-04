package com.clan.instaclass.instituteService.repositories;

import com.clan.instaclass.instituteService.entities.InstituteEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituteRepository extends JpaRepository<InstituteEnt, Integer> {

    public InstituteEnt findByUsername(String username);
}
