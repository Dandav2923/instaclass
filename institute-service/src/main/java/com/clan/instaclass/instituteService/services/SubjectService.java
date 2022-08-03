package com.clan.instaclass.instituteService.services;

import com.clan.instaclass.instituteService.exceptions.subject.SubjectNotFoundException;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectRequest;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectResponse;
import com.clan.instaclass.instituteService.models.subject.GetSubjectResponse;

public interface SubjectService {
    CreateSubjectResponse create(CreateSubjectRequest request);
    GetSubjectResponse get(Integer subjectId) throws SubjectNotFoundException;
}
