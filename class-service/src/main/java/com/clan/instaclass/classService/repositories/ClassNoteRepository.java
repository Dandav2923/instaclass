package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.ClassNoteEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ClassNoteRepository extends JpaRepository<ClassNoteEnt, Integer> {
    @Query("select cn from ClassNoteEnt cn where cn.classEnt.id = :classId")
    public List<ClassNoteEnt> findClassNotes(@Param("classId") Integer id);

    @Query("select cn from ClassNoteEnt cn where cn.classEnt.id = :classId AND cn.teacher = :teacherId")
    public List<ClassNoteEnt> findClassNotesTeacher(@Param("classId") Integer id, @Param("teacherId")Integer idT);
}
