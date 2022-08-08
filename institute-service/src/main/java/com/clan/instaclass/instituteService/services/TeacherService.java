package com.clan.instaclass.instituteService.services;

import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectNotFoundException;
import com.clan.instaclass.instituteService.exceptions.teacher.TeacherAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.teacher.TeacherNotFoundException;
import com.clan.instaclass.instituteService.models.institute.ConnectTeacherSubjectRequest;
import com.clan.instaclass.instituteService.models.subject.GetSubjectResponse;
import com.clan.instaclass.instituteService.models.teacher.*;

import java.util.List;

public interface TeacherService {

    CreateTeacherResponse create(CreateTeacherRequest request) throws DataNonValidException, SubjectAlreadyExistingException, TeacherAlreadyExistingException, TeacherNotFoundException;

    GetTeacherResponse get(Integer subjectId) throws TeacherNotFoundException;

    GetTeacherResponse getUsername(GetUsernameTeacherRequest request) throws TeacherNotFoundException;

    List<GetTeacherResponse> getAll(Integer idInstitute) throws DataNonValidException;

    PutTeacherResponse put(PutTeacherRequest request) throws DataNonValidException, TeacherNotFoundException, TeacherAlreadyExistingException;

    void delete(Integer request) throws DataNonValidException, TeacherNotFoundException;

    public void teacherSubjectConnect(ConnectTeacherSubjectRequest request) throws TeacherNotFoundException, SubjectNotFoundException;
}
