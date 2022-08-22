package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotValidException;
import com.clan.instaclass.classService.models.classes.*;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.services.ClassService;
import com.clan.instaclass.feign.instituteService.InstituteClient;
import com.clan.instaclass.feign.instituteService.models.institute.GetInstituteResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@AllArgsConstructor
@Service
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;
    private final InstituteClient instituteClient;
    @Override
    public CreateClassResponse create(CreateClassRequest request) throws ClassNotValidException, ClassExistException {
        if (request.getName() == null || request.getName().isBlank() || request.getIdInstitute() == null || request.getIdInstitute() <=0){
            throw new ClassNotValidException("Non hai inserito i dati correttamente");
        }
        GetInstituteResponse instituteResponse = instituteClient.getInstitute(request.getIdInstitute());
        List<ClassEnt> listClassEnt = classRepository.findByNameContains(request.getIdInstitute(), request.getName());
        if (listClassEnt == null || listClassEnt.size() == 0){
            ClassEnt newClass = new ClassEnt();
            newClass.setName(request.getName());
            newClass.setInstitute(request.getIdInstitute());
            CreateClassResponse response = new CreateClassResponse();
            response.setId(classRepository.save(newClass).getId());
            response.setName(newClass.getName());
            response.setInstituteName(instituteResponse.getName());
            return response;
        }
        else {
            throw new ClassExistException("Classe già presente nel tuo istituto");
        }
    }
    @Override
    public List<GetClassResponse> findAll(Integer id) {
    List<ClassEnt> entity= classRepository.findByName(id);
    List<GetClassResponse> response = new ArrayList<GetClassResponse>();
    for (ClassEnt subject : entity){
        GetClassResponse getAll = new GetClassResponse();
        getAll.setId(subject.getId());
        getAll.setName(subject.getName());
        getAll.setInstituteId(subject.getInstitute());
        response.add(getAll);
    }
        return response;
    }
    @Override
    public PutClassResponse updateClass(PutClassRequest request) throws ClassNotValidException, ClassNotExistException {
        if (request.getName() != null && !request.getName().isBlank() && request.getInstituteId() != null && request.getInstituteId() > 0) {
            ClassEnt classEnt = classRepository.findById(request.getId()).orElseThrow(() -> new ClassNotExistException("Classe non trovata"));
            if (classEnt.getInstitute() != request.getInstituteId()) {
                throw new ClassNotValidException("Non sei autorizzato a modificare questa classe");
            } else {
                classEnt.setName(request.getName());
                PutClassResponse response = new PutClassResponse();
                response.setName(classRepository.save(classEnt).getName());
                response.setInstituteId(classEnt.getInstitute());
                return response;
            }
        } else {
            throw new ClassNotValidException("Non hai inserito i dati correttamente");
        }
    }

    @Override
    public void deleteClass(DeleteClassRequest request) throws ClassNotValidException, ClassNotExistException {
        if (request.getName() != null && !request.getName().isBlank() && request.getInstituteId() != null && request.getInstituteId() > 0) {
            ClassEnt classEnt =classRepository.findById(request.getId()).orElseThrow(() -> new ClassNotExistException("Classe non trovata"));
            if (classEnt.getInstitute() != request.getInstituteId()) {
                throw new ClassNotValidException("Non sei autorizzato a modificare questa classe");
            } else {
                this.classRepository.delete(classEnt);
            }
        } else {
            throw new ClassNotValidException("Non hai inserito i dati correttamente");



        }
    }
}
