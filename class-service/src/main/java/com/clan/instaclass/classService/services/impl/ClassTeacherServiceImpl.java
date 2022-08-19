package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.ClassTeacherRel;
import com.clan.instaclass.classService.exceptions.classTeacher.ClassTeacherExistException;
import com.clan.instaclass.classService.exceptions.classTeacher.ClassTeacherNotExistException;
import com.clan.instaclass.classService.exceptions.classTeacher.ClassTeacherNotValidException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.models.classTeacher.*;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.repositories.ClassTeacherRepository;
import com.clan.instaclass.classService.services.ClassTeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class ClassTeacherServiceImpl implements ClassTeacherService {
    private ClassTeacherRepository classTeacherRepository;
    private ClassRepository classRepository;

    @Override
    public CreateClassTeacherResponse create(CreateClassTeacherRequest request) throws ClassTeacherNotValidException, ClassTeacherExistException, ClassNotExistException {
        if (request.getClassId() == null || request.getClassId() <= 0 || request.getTeacherId() == null || request.getTeacherId() <= 0 || request.getSubjectId() == null || request.getSubjectId() <= 0) {
            throw new ClassTeacherNotValidException("Hai inserito dati errati o nulli");
        }
        List<ClassTeacherRel> teacherRelList = classTeacherRepository.getAllByIdClass(request.getClassId());
        for (ClassTeacherRel element : teacherRelList) {
            if (element.getTeacher() != request.getTeacherId()) {
                ClassTeacherRel newClassTeacherRel = new ClassTeacherRel();
                newClassTeacherRel.setTeacher(request.getTeacherId());
                newClassTeacherRel.setSubject(request.getSubjectId());
                newClassTeacherRel.setClassEnt(classRepository.getReferenceById(request.getClassId()));
                CreateClassTeacherResponse response = new CreateClassTeacherResponse();
                response.setId(classTeacherRepository.save(newClassTeacherRel).getId());
                response.setTeacherId(newClassTeacherRel.getTeacher());
                response.setSubjectId(newClassTeacherRel.getSubject());
                response.setClassId(newClassTeacherRel.getClassEnt().getId());
                return response;
            } else {
                throw new ClassTeacherExistException("Docente già inserito nella classe");
            }
        }
        return null;
    }

    @Override
    public List<GetClassTeacherResponse> findAllTeacherByClass(Integer id) throws ClassTeacherNotValidException {
        if (id == null || id <= 0 ){
            throw new ClassTeacherNotValidException("Hai inserito un id non valido");
        }
        List<ClassTeacherRel> teacherRelList = classTeacherRepository.getAllByIdClass(id);
        List<GetClassTeacherResponse> response = new ArrayList<GetClassTeacherResponse>();
        for (ClassTeacherRel element : teacherRelList){
            GetClassTeacherResponse getAll = new GetClassTeacherResponse();
            getAll.setId(element.getId());
            getAll.setTeacherId(element.getTeacher());
            getAll.setSubjectId(element.getSubject());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public PutClassTeacherResponse updateClassTeacher(PutClassTeacherRequest request) throws ClassTeacherNotValidException, ClassTeacherNotExistException {
        if (request.getClassId() != null && request.getClassId() > 0 && request.getTeacherId() != null && request.getTeacherId() > 0 && request.getSubjectId() != null && request.getSubjectId() > 0){
            ClassTeacherRel classTeacherRel = classTeacherRepository.findById(request.getId()).orElseThrow(() -> new ClassTeacherNotExistException("Docente nella classe con id" + request.getTeacherId() + "non trovato"));
            if (classTeacherRel.getTeacher() != request.getTeacherId() && classTeacherRel.getClassEnt().getId() != request.getClassId()){
                throw new ClassTeacherNotValidException("Non sei autorizzato a modificare questo campo");
            }else{
                classTeacherRel.setTeacher(request.getTeacherId());
                classTeacherRel.setSubject(request.getSubjectId());
                classTeacherRel.setClassEnt(classRepository.getReferenceById(request.getClassId()));
                PutClassTeacherResponse response = new PutClassTeacherResponse();
                response.setId(classTeacherRepository.save(classTeacherRel).getId());
                response.setTeacherId(classTeacherRel.getTeacher());
                response.setSubjectId(classTeacherRel.getSubject());
                response.setClassId(classTeacherRel.getClassEnt().getId());
                return response;
            }
        } else {
            throw new ClassTeacherNotValidException("Non hai inserito i dati correttamente");
        }
    }

    @Override
    public void deleteClassTeacher(DeleteClassTeacherRequest request) throws ClassTeacherNotValidException, ClassTeacherNotExistException {
        if (request.getClassId() != null && request.getClassId() > 0 && request.getTeacherId() != null && request.getTeacherId() > 0 && request.getId() != null && request.getId() > 0) {
            ClassTeacherRel classTeacherRel = classTeacherRepository.findById(request.getId()).orElseThrow(() -> new ClassTeacherNotExistException("Docente nella classe con id" + request.getTeacherId() + "non trovato"));
            if (classTeacherRel.getTeacher() != request.getTeacherId() && classTeacherRel.getClassEnt().getId() != request.getClassId()){
                throw new ClassTeacherNotValidException("Non sei autorizzato a modificare questo campo");
            }else{
                classTeacherRepository.delete(classTeacherRel);
            }
        }else{
            throw new ClassTeacherNotValidException("Non hai inserito i dati correttamente");
        }
    }
}
