package com.clan.instaclass.instituteService.services;

import com.clan.instaclass.feign.instituteService.models.student.*;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.student.StudentAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.student.StudentNotFoundException;
import com.clan.instaclass.instituteService.models.student.*;

import java.util.List;

public interface StudentService {

    CreateStudentResponse create(CreateStudentRequest request) throws DataNonValidException, StudentAlreadyExistingException;

    GetStudentResponse get(Integer studentId) throws StudentNotFoundException;

    GetStudentResponse getUsername(GetUsernameStudentRequest request) throws StudentNotFoundException;

    PutStudentResponse put(PutStudentRequest request) throws DataNonValidException, StudentNotFoundException, StudentAlreadyExistingException;

    List<GetStudentResponse> getAll(Integer idInstitute) throws DataNonValidException;

    public void delete(Integer request) throws DataNonValidException, StudentNotFoundException;
}
