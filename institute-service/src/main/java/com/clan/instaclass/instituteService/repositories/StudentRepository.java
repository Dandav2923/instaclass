package com.clan.instaclass.instituteService.repositories;

import com.clan.instaclass.instituteService.entities.StudentEnt;
import com.clan.instaclass.instituteService.entities.TeacherEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEnt, Integer> {

    @Query("SELECT s FROM StudentEnt s WHERE s.institute.id = :id")
    public List<StudentEnt> getAllStudentByInstitute(@Param("id") Integer idInstitute);

    @Query("SELECT s FROM StudentEnt s WHERE s.institute.id = :id AND s.username = :username")
    public StudentEnt findStudentByUsernameAndInstitute(@Param("id") Integer idInstitute,@Param("username") String username);
}
