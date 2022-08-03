package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.ClassNoteEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNoteRepository extends JpaRepository<ClassNoteEnt, Integer> {
}
