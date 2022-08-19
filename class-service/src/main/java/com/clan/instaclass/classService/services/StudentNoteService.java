package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.studentNote.StudentNoteExistException;
import com.clan.instaclass.classService.exceptions.studentNote.StudentNoteNotExistException;
import com.clan.instaclass.classService.exceptions.studentNote.StudentNoteNotValidException;
import com.clan.instaclass.classService.models.presence.PutPresenceResponse;
import com.clan.instaclass.classService.models.studentNote.*;

import java.util.List;

public interface StudentNoteService {
    CreateStudentNoteResponse create(CreateStudentNoteRequest request) throws StudentNoteNotValidException, StudentNoteExistException, ClassNotExistException;
    List<GetStudentNoteResponse> findAllStudentNotes(Integer id) throws StudentNoteNotExistException;
    List<GetStudentNoteResponse> findAllStudentNotesByIdStudent(Integer idClass, Integer idStudent) throws StudentNoteNotValidException, StudentNoteNotExistException;
    List<GetStudentNoteResponse> findAllStudentNotesByIdTeacher(Integer idClass, Integer idTeacher) throws StudentNoteNotValidException, StudentNoteNotExistException;
    PutStudentNoteResponse updateStudentNote(PutStudentNoteRequest request) throws StudentNoteNotValidException, StudentNoteNotExistException;
    void deleteStudentNote(DeleteStudentNoteRequest request) throws StudentNoteNotValidException, StudentNoteNotExistException;
}
