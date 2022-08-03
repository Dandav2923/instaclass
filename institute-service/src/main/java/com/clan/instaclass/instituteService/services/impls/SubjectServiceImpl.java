package com.clan.instaclass.instituteService.services.impls;

import com.clan.instaclass.instituteService.entities.SubjectEnt;
import com.clan.instaclass.instituteService.exceptions.SubjectNotFoundException;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectRequest;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectResponse;
import com.clan.instaclass.instituteService.models.subject.GetSubjectResponse;
import com.clan.instaclass.instituteService.repositories.InstituteRepository;
import com.clan.instaclass.instituteService.repositories.SubjectRepository;
import com.clan.instaclass.instituteService.services.SubjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;
    private InstituteRepository instituteRepository;

    @Override
    public CreateSubjectResponse create(CreateSubjectRequest request) {
        SubjectEnt entity = new SubjectEnt();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setInstitute(instituteRepository.getReferenceById(request.getInstituteId()));
        CreateSubjectResponse response = new CreateSubjectResponse();
        response.setId(subjectRepository.save(entity).getId());
        return response;
    }

    @Override
    public GetSubjectResponse get(Integer subjectId) throws SubjectNotFoundException {
        GetSubjectResponse response = new GetSubjectResponse();
        SubjectEnt entity = subjectRepository.findById(subjectId).orElseThrow(SubjectNotFoundException::new);
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setInstituteId(entity.getInstitute().getId());
        return response;
    }
}
