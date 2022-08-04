package com.clan.instaclass.instituteService.repositories;

import com.clan.instaclass.instituteService.entities.SubjectEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEnt, Integer> {

    @Query("SELECT s FROM SubjectEnt s WHERE s.institute.id = :id")
    public List<SubjectEnt> findSubjectByInstitute(@Param("id") Integer idInstitute);
}
