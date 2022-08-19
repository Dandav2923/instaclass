package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.classStudent.ClassStudentNotExistException;
import com.clan.instaclass.classService.exceptions.classStudent.ClassStudentNotValidException;
import com.clan.instaclass.classService.exceptions.classStudent.StudentAlreadyExistingException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.models.classStudent.*;

import java.util.List;

public interface ClassStudentService {

    CreateClassStudentResponse create(CreateClassStudentRequest request) throws ClassStudentNotValidException, ClassNotExistException, StudentAlreadyExistingException;

    List<GetClassStudentResponse> get(Integer classId) throws ClassStudentNotValidException, ClassNotExistException;

    PutClassStudentResponse put(PutClassStudentRequest request) throws StudentAlreadyExistingException, ClassStudentNotValidException, ClassStudentNotExistException, ClassNotExistException;
}
