package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.entities.ClassStudentRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassStudentRepository extends JpaRepository<ClassStudentRel, Integer> {

    @Query("select c from ClassStudentRel c where c.classEnt.id = :idClass")
    public List<ClassStudentRel> findByIdClass(@Param("idClass")Integer id);
}
