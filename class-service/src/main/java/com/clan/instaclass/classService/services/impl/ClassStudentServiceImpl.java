package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.entities.ClassStudentRel;
import com.clan.instaclass.classService.exceptions.classStudent.ClassStudentNotExistException;
import com.clan.instaclass.classService.exceptions.classStudent.ClassStudentNotValidException;
import com.clan.instaclass.classService.exceptions.classStudent.StudentAlreadyExistingException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.models.classStudent.*;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.repositories.ClassStudentRepository;
import com.clan.instaclass.classService.services.ClassStudentService;
import com.clan.instaclass.feign.instituteService.InstituteClient;
import com.clan.instaclass.feign.instituteService.models.student.GetStudentResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ClassStudentServiceImpl implements ClassStudentService {

    private ClassStudentRepository classStudentRepository;

    private InstituteClient instituteClient;

    private ClassRepository classRepository;
    @Override
    public CreateClassStudentResponse create(CreateClassStudentRequest request) throws ClassStudentNotValidException, ClassNotExistException, StudentAlreadyExistingException {
        if (request.getClassId() == null || request.getClassId() < 1 || request.getStudentId() == null || request.getStudentId() < 1) {
            throw new ClassStudentNotValidException("dati mancanti");
        }
        ClassEnt classEnt = classRepository.findById(request.getClassId()).orElseThrow(() -> new ClassNotExistException("Classe non trovata"));

        for (ClassStudentRel student: classStudentRepository.findAll()) {
            if (student.getStudent() == request.getStudentId() && student.getClassEnt().getId() == request.getClassId()){
                throw new StudentAlreadyExistingException("studente in quella classe gia esistente");
            }
        }
        ClassStudentRel entity = new ClassStudentRel();
        entity.setStudent(request.getStudentId());
        entity.setClassEnt(classEnt);
        CreateClassStudentResponse response = new CreateClassStudentResponse();
        response.setId(classStudentRepository.save(entity).getId());
        response.setStudentId(entity.getStudent());
        response.setClassId(entity.getClassEnt().getId());
        return response;

    }

    @Override
    public List<GetClassStudentResponse> get(Integer classId) throws ClassStudentNotValidException, ClassNotExistException {
        if (classId == null || classId < 1) {
            throw new ClassStudentNotValidException("dati non validi");
        }
        classRepository.findById(classId).orElseThrow(() -> new ClassNotExistException("classe non trovata"));

        List<GetClassStudentResponse> response = new ArrayList<>();

        List<ClassStudentRel> classStudentRel = classStudentRepository.findByIdClass(classId);

        for (ClassStudentRel student: classStudentRel) {
            GetClassStudentResponse getClassStudent = new GetClassStudentResponse();
            GetStudentResponse getStudent = instituteClient.getStudent(student.getStudent());
            getClassStudent.setName(getStudent.getName());
            getClassStudent.setFiscalCode(getStudent.getFiscalCode());
            getClassStudent.setSurname(getStudent.getSurname());
            getClassStudent.setUsername(getStudent.getUsername());
            response.add(getClassStudent);
        }

        return response;
    }

    @Override
    public PutClassStudentResponse put(PutClassStudentRequest request) throws StudentAlreadyExistingException, ClassStudentNotValidException, ClassStudentNotExistException, ClassNotExistException {
        if (request.getId() == null ||
            request.getClassId() == null ||
            request.getStudentId() == null
        ) {
            throw new ClassStudentNotValidException("dati mancanti");
        }
        ClassEnt classEntity = classRepository.findById(request.getClassId()).orElseThrow(() -> new ClassNotExistException("classe non trovata"));
        ClassStudentRel entity = classStudentRepository.findById(request.getId()).orElseThrow(() -> new ClassStudentNotExistException("Class student non trovata"));
        for (ClassStudentRel student: classStudentRepository.findAll()) {
            if (student.getStudent() == request.getStudentId() && student.getClassEnt().getId() == request.getClassId()){
                throw new StudentAlreadyExistingException("studente in quella classe gia esistente");
            }
        }
        entity.setStudent(request.getStudentId());
        entity.setClassEnt(classEntity);
        PutClassStudentResponse response = new PutClassStudentResponse();
        response.setClassId(request.getClassId());
        response.setStudentId(request.getStudentId());
        response.setId(classStudentRepository.save(entity).getId());
        return response;
    }

    @Override
    public void deleteClassStudent(DeleteClassStudentRequest request) throws ClassStudentNotValidException, ClassStudentNotExistException, ClassNotExistException {
        if (request.getId() == null ||
                request.getClassId() == null ||
                request.getStudentId() == null
        ) {
            throw new ClassStudentNotValidException("dati mancanti");
        }
        ClassStudentRel classStudentRel = classStudentRepository.findById(request.getClassId()).orElseThrow(() -> new ClassStudentNotExistException("Studente nella classe con id " + request.getClassId() + " non trovato"));
        classStudentRepository.delete(classStudentRel);
    }

}
