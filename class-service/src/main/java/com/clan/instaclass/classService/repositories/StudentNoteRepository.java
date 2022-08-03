package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.StudentNoteEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentNoteRepository extends JpaRepository<StudentNoteEnt, Integer> {
}
