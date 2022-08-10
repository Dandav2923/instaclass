package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.EventEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEnt, Integer> {
    @Query("select e from EventEnt e where e.classEnt.id = :classId")
    public List<EventEnt> findEvents(@Param("classId") Integer id);
}
