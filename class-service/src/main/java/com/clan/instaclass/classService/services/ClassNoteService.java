package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.classNote.ClassNoteExistException;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteNotExistException;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteNotValidException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.models.classNote.*;

import java.util.List;

public interface ClassNoteService {
    CreateClassNoteResponse create(CreateClassNoteRequest request) throws ClassNoteNotValidException, ClassNoteExistException, ClassNotExistException;
    List<GetClassNoteResponse> findAllClassNotes(Integer id) throws ClassNoteNotValidException;
    List<GetClassNoteResponse> findAllClassNotesTeacher(Integer classId, Integer teacherId)throws ClassNoteNotValidException, ClassNoteNotExistException;
    PutClassNoteResponse updateClassNoteTeacher(PutClassNoteRequest request) throws ClassNoteNotValidException,ClassNoteNotExistException;
    void deleteClassNoteTeacher(DeleteClassNoteRequest request) throws ClassNoteNotValidException,ClassNoteNotExistException;
}
