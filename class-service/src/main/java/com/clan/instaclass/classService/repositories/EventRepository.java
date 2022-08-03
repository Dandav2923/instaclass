package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.EventEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventEnt, Integer> {
}
