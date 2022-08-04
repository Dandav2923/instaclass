package com.clan.instaclass.instituteService.services.impls;

import com.clan.instaclass.instituteService.entities.SubjectEnt;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectNotFoundException;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectRequest;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectResponse;
import com.clan.instaclass.instituteService.models.subject.GetSubjectResponse;
import com.clan.instaclass.instituteService.repositories.InstituteRepository;
import com.clan.instaclass.instituteService.repositories.SubjectRepository;
import com.clan.instaclass.instituteService.services.SubjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class SubjectServiceImpl implements SubjectService {
    private SubjectRepository subjectRepository;
    private InstituteRepository instituteRepository;

    @Override
    public CreateSubjectResponse create(CreateSubjectRequest request) throws DataNonValidException, SubjectAlreadyExistingException {
        if (request.getName() == null || request.getInstituteId() < 1) {
            throw new DataNonValidException("dati mancanti");
        }
        List<SubjectEnt> subjectByInstitute = subjectRepository.findSubjectByInstitute(request.getInstituteId());
        for(SubjectEnt subject : subjectByInstitute) {
            if (subject.getName().equalsIgnoreCase(request.getName())){
                throw new SubjectAlreadyExistingException("materia gia esistente");
            }
        }
        SubjectEnt entity = new SubjectEnt();
        entity.setName(request.getName());
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
        response.setInstituteId(entity.getInstitute().getId());
        return response;
    }
}
