package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.ClassEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<ClassEnt, Integer> {
}
