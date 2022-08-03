package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.ClassTeacherRel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTeacherRepository extends JpaRepository<ClassTeacherRel, Integer> {
}
