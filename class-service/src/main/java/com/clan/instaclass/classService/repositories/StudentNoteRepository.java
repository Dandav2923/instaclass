package com.clan.instaclass.classService.repositories;

import com.clan.instaclass.classService.entities.StudentNoteEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentNoteRepository extends JpaRepository<StudentNoteEnt, Integer> {
    @Query("select sn from StudentNoteEnt sn where sn.classEnt.id = :idClass")
    public List<StudentNoteEnt> findAllStudentNote(@Param("idClass") Integer id);
    @Query("select sn from StudentNoteEnt sn where sn.classEnt.id = :idClass AND sn.student = :idStudent")
    public List<StudentNoteEnt> findAllStudentNoteByIdStudent(@Param("idClass")Integer idClass, @Param("idStudent")Integer idStudent);
    @Query("select sn from StudentNoteEnt sn where sn.classEnt.id = :idClass AND sn.teacher = :idTeacher")
    public List<StudentNoteEnt> findAllStudentNoteByIdTeacher(@Param("idClass")Integer idClass, @Param("idTeacher")Integer idTeacher);
}
