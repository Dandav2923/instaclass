package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.ClassNoteEnt;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteExistException;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteNotExistException;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteNotValidException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.models.classNote.*;
import com.clan.instaclass.classService.repositories.ClassNoteRepository;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.services.ClassNoteService;
import com.clan.instaclass.feign.instituteService.InstituteClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@AllArgsConstructor
@Service
public class ClassNoteServiceImpl implements ClassNoteService {
    private ClassNoteRepository classNoteRepository;
    private ClassRepository classRepository;
    private InstituteClient instituteClient;
    @Override
    public CreateClassNoteResponse create(CreateClassNoteRequest request) throws ClassNoteNotValidException, ClassNoteExistException, ClassNotExistException {
        if (request.getNote() == null || request.getNote().isBlank() || request.getDate() == null || request.getTeacherId() == null || request.getTeacherId() <= 0 || request.getClassId() == 0){
            throw new ClassNoteNotValidException("Non hai inserito i dati correttamente");
        }
        ClassNoteEnt newClassNoteEnt = new ClassNoteEnt();
        newClassNoteEnt.setNote(request.getNote());
        newClassNoteEnt.setDate(request.getDate());
        newClassNoteEnt.setTeacher(request.getTeacherId());
        newClassNoteEnt.setClassEnt(classRepository.getReferenceById(request.getClassId()));
        CreateClassNoteResponse response = new CreateClassNoteResponse();
        response.setId(classNoteRepository.save(newClassNoteEnt).getId());
        response.setNote(newClassNoteEnt.getNote());
        response.setDate(newClassNoteEnt.getDate());
        response.setTeacherId(newClassNoteEnt.getTeacher());
        response.setClassId(newClassNoteEnt.getClassEnt().getId());
        return response;
    }

    @Override
    public List<GetClassNoteResponse> findAllClassNotes(Integer id) throws ClassNoteNotValidException {
        if (id == null || id <= 0){
            throw new ClassNoteNotValidException("Hai inserito un id non valido");
        }
        List<ClassNoteEnt> listClassNoteEnt = classNoteRepository.findClassNotes(id);
        List<GetClassNoteResponse> response = new ArrayList<GetClassNoteResponse>();
        for (ClassNoteEnt element : listClassNoteEnt){
            GetClassNoteResponse getAll = new GetClassNoteResponse();
            getAll.setId(element.getId());
            getAll.setNote(element.getNote());
            getAll.setDate(element.getDate());
            getAll.setTeacherName(instituteClient.getTeacher(element.getTeacher()).getName());
            getAll.setTeacherSurname(instituteClient.getTeacher(element.getTeacher()).getSurname());
            getAll.setFiscalCode(instituteClient.getTeacher(element.getTeacher()).getFiscalCode());
            getAll.setUsername(instituteClient.getTeacher(element.getTeacher()).getUsername());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public List<GetClassNoteResponse> findAllClassNotesTeacher(Integer classId, Integer teacherId) throws ClassNoteNotValidException, ClassNoteNotExistException {
        if (classId == null || classId <= 0 || teacherId == null || teacherId <= 0 ){
            throw new ClassNoteNotValidException("Hai inserito l'id della classe o del docente non validi");
        }
        List<ClassNoteEnt> listClassNoteEnt = classNoteRepository.findClassNotesTeacher(classId,teacherId);
        if (listClassNoteEnt.size() <= 0){
            throw new ClassNoteNotExistException("Non esiste nessuna nota di classe per questo docente");
        }
        List<GetClassNoteResponse> response = new ArrayList<GetClassNoteResponse>();
        for (ClassNoteEnt element : listClassNoteEnt){
            GetClassNoteResponse getAll = new GetClassNoteResponse();
            getAll.setId(element.getId());
            getAll.setNote(element.getNote());
            getAll.setDate(element.getDate());
            getAll.setTeacherName(instituteClient.getTeacher(element.getTeacher()).getName());
            getAll.setTeacherSurname(instituteClient.getTeacher(element.getTeacher()).getSurname());
            getAll.setFiscalCode(instituteClient.getTeacher(element.getTeacher()).getFiscalCode());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public PutClassNoteResponse updateClassNoteTeacher(PutClassNoteRequest request) throws ClassNoteNotValidException, ClassNoteNotExistException {
        if (request.getNote() != null && !request.getNote().isBlank() && request.getDate() != null && request.getTeacherId() != null && request.getTeacherId() > 0 && request.getClassId() > 0){
            ClassNoteEnt classNoteEnt = classNoteRepository.findById(request.getId()).orElseThrow(() -> new ClassNoteNotExistException("Nota classe non trovata"));
            if(classNoteEnt.getClassEnt().getId() != request.getClassId() && classNoteEnt.getTeacher() != request.getTeacherId()){
                throw new ClassNoteNotValidException("Non sei autorizzato a modificare questa nota di classe");
            }else {
                classNoteEnt.setNote(request.getNote());
                classNoteEnt.setDate(request.getDate());
                PutClassNoteResponse response = new PutClassNoteResponse();
                response.setId(classNoteRepository.save(classNoteEnt).getId());
                response.setNote(classNoteEnt.getNote());
                response.setDate(classNoteEnt.getDate());
                response.setTeacherId(classNoteEnt.getTeacher());
                response.setClassId(classNoteEnt.getClassEnt().getId());
                return response;
            }
        }else{
            throw new ClassNoteNotValidException("Non hai inserito i dati correttamente");
        }
    }

    @Override
    public void deleteClassNoteTeacher(DeleteClassNoteRequest request) throws ClassNoteNotValidException, ClassNoteNotExistException {
        if (request.getId() != null && request.getId() > 0 && request.getTeacherId() != null && request.getTeacherId()> 0 && request.getClassId() != null){
            ClassNoteEnt classNoteEnt = classNoteRepository.findById(request.getId()).orElseThrow(() -> new ClassNoteNotExistException("Nota classe non trovata"));
            if(classNoteEnt.getClassEnt().getId() != request.getClassId() && classNoteEnt.getTeacher() != request.getTeacherId()){
                throw new ClassNoteNotValidException("Non sei autorizzato a modificare questa nota di classe");
            }else {
                classNoteRepository.delete(classNoteEnt);
            }
        }else {
            throw new ClassNoteNotValidException("Non hai inserito i dati correttamente");
        }
    }
}
