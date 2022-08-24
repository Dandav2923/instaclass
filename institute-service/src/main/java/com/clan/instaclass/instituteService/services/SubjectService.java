package com.clan.instaclass.instituteService.services;

import com.clan.instaclass.feign.instituteService.models.subject.*;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectNotFoundException;

import java.util.List;

public interface SubjectService {
    CreateSubjectResponse create(CreateSubjectRequest request) throws DataNonValidException, SubjectAlreadyExistingException;
    GetSubjectResponse get(Integer subjectId) throws SubjectNotFoundException;

    List<GetSubjectResponse> getAll(Integer idInstitute);

    PutSubjectResponse put(PutSubjectRequest request) throws DataNonValidException, SubjectNotFoundException, SubjectAlreadyExistingException;

    void delete(Integer id) throws DataNonValidException, SubjectNotFoundException;
}
