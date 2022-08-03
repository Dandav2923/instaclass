package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.HomeworkEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkRepository extends JpaRepository<HomeworkEnt, Integer> {
}
