package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.ClassTeacherRel;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassTeacherRepository extends JpaRepository<ClassTeacherRel, Integer> {
    @Query("select ct from ClassTeacherRel ct where ct.classEnt.id = :idClass")
    public List<ClassTeacherRel> getAllByIdClass (@Param("idClass")Integer id);
}
