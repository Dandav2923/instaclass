package com.clan.instaclass.instituteService.repositories;

import com.clan.instaclass.instituteService.entities.SubjectEnt;
import com.clan.instaclass.instituteService.entities.TeacherEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherEnt, Integer> {

    @Query("SELECT t FROM TeacherEnt t WHERE t.institute.id = :id")
    public List<TeacherEnt> getAllTeacherByInstitute(@Param("id") Integer idInstitute);

    @Query("SELECT t FROM TeacherEnt t WHERE t.institute.id = :id AND t.username = :username")
    public TeacherEnt findTeacherByUsernameAndInstitute(@Param("id") Integer idInstitute,@Param("username") String username);



}