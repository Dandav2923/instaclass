package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.PresenceEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PresenceRepository extends JpaRepository<PresenceEnt, Integer> {
    @Query("select p from PresenceEnt p where p.classEnt.id = :idClass")
    public List<PresenceEnt> findPresences(@Param("idClass")Integer id);
    @Query("select p from PresenceEnt p where p.classEnt.id = :idClass AND p.student = :idStudent")
    public List<PresenceEnt> findPresencesByStudent(@Param("idClass")Integer idClass, @Param("idStudent")Integer idStudent);
}
