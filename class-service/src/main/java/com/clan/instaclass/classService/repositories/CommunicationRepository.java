package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.CommunicationEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunicationRepository extends JpaRepository<CommunicationEnt, Integer> {
    @Query("select c from CommunicationEnt c where c.classEnt.id = :classId")
    public List<CommunicationEnt> findCommunications(@Param("classId") Integer id);
}
