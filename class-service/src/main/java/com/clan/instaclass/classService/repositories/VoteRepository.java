package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.VoteEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteEnt, Integer> {

    @Query("SELECT v FROM VoteEnt v WHERE v.student = :id")
    public List<VoteEnt> getAllVoteByStudent(@Param("id") Integer idStudent);

    @Query("SELECT v FROM VoteEnt v WHERE v.classEnt.id = :id")
    public List<VoteEnt> getAllVoteByClass(@Param("id") Integer idClass);

    @Query("SELECT v FROM VoteEnt v WHERE v.teacher = :id")
    public List<VoteEnt> getAllVoteByTeacher(@Param("id") Integer idTeacher);
}
