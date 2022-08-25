package com.clan.instaclass.instituteService.services.impls;

import com.clan.instaclass.feign.instituteService.models.subject.*;
import com.clan.instaclass.instituteService.entities.SubjectEnt;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectNotFoundException;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectRequest;
import com.clan.instaclass.instituteService.models.subject.CreateSubjectResponse;
import com.clan.instaclass.instituteService.models.subject.PutSubjectRequest;
import com.clan.instaclass.instituteService.models.subject.PutSubjectResponse;
import com.clan.instaclass.instituteService.repositories.InstituteRepository;
import com.clan.instaclass.instituteService.repositories.SubjectRepository;
import com.clan.instaclass.instituteService.services.SubjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<SubjectEnt> subjectByInstitute = subjectRepository.getAllSubjectByInstitute(request.getInstituteId());
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

    @Override
    public List<GetSubjectResponse> getAll(Integer idInstitute) {
        List<SubjectEnt> entity = subjectRepository.getAllSubjectByInstitute(idInstitute);
        List<GetSubjectResponse> response = new ArrayList<GetSubjectResponse>();
        for (SubjectEnt subject : entity){
            GetSubjectResponse getAll = new GetSubjectResponse();
            getAll.setId(subject.getId());
            getAll.setName(subject.getName());
            getAll.setInstituteId(subject.getInstitute().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public PutSubjectResponse put(PutSubjectRequest request) throws DataNonValidException, SubjectNotFoundException, SubjectAlreadyExistingException {
        if (request.getName() == null || request.getId() == null) {
            throw new DataNonValidException("dati mancanti");
        }

        SubjectEnt entity = subjectRepository.findById(request.getId()).orElseThrow(() -> new SubjectNotFoundException("materia non trovata"));


        List<SubjectEnt> list = subjectRepository.getAllSubjectByInstitute(entity.getInstitute().getId());
        for(SubjectEnt subject : list) {
            if (subject.getName().equalsIgnoreCase(request.getName())){
                throw new SubjectAlreadyExistingException("materia gia esistente");
            }
        }

        entity.setName(request.getName());

        PutSubjectResponse response = new PutSubjectResponse();
        response.setName(request.getName());
        response.setId(subjectRepository.save(entity).getId());
        return response;
    }

    public void delete(Integer request) throws DataNonValidException, SubjectNotFoundException {
        if (request == null || request < 1) {
            throw new DataNonValidException("dati mancanti");
        }
        SubjectEnt entity = subjectRepository.findById(request).orElseThrow(()->new SubjectNotFoundException("materia non trovato"));

        subjectRepository.deleteById(request);

    }

}
