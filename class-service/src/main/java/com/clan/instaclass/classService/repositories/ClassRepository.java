package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.ClassEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<ClassEnt, Integer> {
    public List<ClassEnt> findByNameIgnoreCase(String name);
    public List<ClassEnt> findByNameContainsIgnoreCase(String name);
    @Query("select c from ClassEnt c where c.institute.id = :idInstitute")
    public  List<ClassEnt> findByName(@Param("idInstitute")Integer id);
    @Query("select c from ClassEnt c where c.institute = :idInstitute AND c.name LIKE :name")
    public List<ClassEnt> findByNameContains(@Param("idInstitute")Integer id, @Param("name")String name);


}
