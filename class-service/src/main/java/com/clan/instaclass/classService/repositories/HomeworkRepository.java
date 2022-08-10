package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.HomeworkEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEnt, Integer> {
    @Query("select h from HomeworkEnt h where h.classEnt.id = :classId")
    public List<HomeworkEnt> findHomeworks(@Param("classId") Integer id);
}
