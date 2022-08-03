package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.ClassStudentRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassStudentRepository extends JpaRepository<ClassStudentRel, Integer> {
}
