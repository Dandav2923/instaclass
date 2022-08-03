package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.PresenceEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresenceRepository extends JpaRepository<PresenceEnt, Integer> {
}
