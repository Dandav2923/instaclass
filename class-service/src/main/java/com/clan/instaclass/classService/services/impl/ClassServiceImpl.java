package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotValidException;
import com.clan.instaclass.classService.models.classes.CreateClassRequest;
import com.clan.instaclass.classService.models.classes.CreateClassResponse;
import com.clan.instaclass.classService.models.classes.GetClassResponse;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.services.ClassService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@AllArgsConstructor
@Service
public class ClassServiceImpl implements ClassService {
    private ClassRepository classRepository;


    @Override
    public CreateClassResponse create(CreateClassRequest request) throws ClassNotValidException, ClassExistException {
        if (request.getName() == null || request.getName().isBlank() || request.getIdInstitute() == null || request.getIdInstitute() <=0){
            throw new ClassNotValidException("Non hai inserito i dati correttamente");
        }
        List<ClassEnt> listClassEnt = classRepository.findByNameContains(request.getIdInstitute(), request.getName());
        if (listClassEnt == null || listClassEnt.size() == 0){
            ClassEnt newClass = new ClassEnt();
            newClass.setName(request.getName());
            newClass.setInstitute(request.getIdInstitute());
            CreateClassResponse response = new CreateClassResponse();
            response.setId(classRepository.save(newClass).getId());
            response.setName(newClass.getName());
            return response;
        }
        else {
            throw new ClassExistException("Classe già presente nel tuo istituto");
        }
    }
    @Override
    public GetClassResponse get(Integer id) throws ClassNotExistException {
        GetClassResponse response = new GetClassResponse();
        ClassEnt classEnt = classRepository.findById(id).orElseThrow(() -> new ClassNotExistException("Classe non trovata"));
        response.setId(classEnt.getId());
        response.setNome(classEnt.getName());
        response.setInstituteId(classEnt.getInstitute());
        return response;
    }

    @Override
    public List<GetClassResponse> findAll(Integer id) {
    List<ClassEnt> entity= classRepository.findByName(id);
    List<GetClassResponse> response = new ArrayList<GetClassResponse>();
    for (ClassEnt subject : entity){
        GetClassResponse getAll = new GetClassResponse();
        getAll.setId(subject.getId());
        getAll.setNome(subject.getName());
        getAll.setInstituteId(subject.getInstitute());
        response.add(getAll);
    }
        return response;
    }
}
