package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.classTeacher.ClassTeacherExistException;
import com.clan.instaclass.classService.exceptions.classTeacher.ClassTeacherNotExistException;
import com.clan.instaclass.classService.exceptions.classTeacher.ClassTeacherNotValidException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.models.classTeacher.*;

import java.util.List;

public interface ClassTeacherService {
    CreateClassTeacherResponse create(CreateClassTeacherRequest request) throws ClassTeacherNotValidException, ClassTeacherExistException, ClassNotExistException;
    List<GetClassTeacherResponse> findAllTeacherByClass(Integer id) throws ClassTeacherNotValidException;
    PutClassTeacherResponse updateClassTeacher(PutClassTeacherRequest request) throws ClassTeacherNotValidException, ClassTeacherNotExistException;
    void deleteClassTeacher(DeleteClassTeacherRequest request) throws ClassTeacherNotValidException, ClassTeacherNotExistException;
}
