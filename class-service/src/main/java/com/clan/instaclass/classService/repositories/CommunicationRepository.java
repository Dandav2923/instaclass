package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.CommunicationEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunicationRepository extends JpaRepository<CommunicationEnt, Integer> {
}
