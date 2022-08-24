package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.PresenceEnt;
import com.clan.instaclass.classService.entities.StudentNoteEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceNotValidException;
import com.clan.instaclass.classService.exceptions.studentNote.StudentNoteExistException;
import com.clan.instaclass.classService.exceptions.studentNote.StudentNoteNotExistException;
import com.clan.instaclass.classService.exceptions.studentNote.StudentNoteNotValidException;
import com.clan.instaclass.classService.models.presence.PutPresenceResponse;
import com.clan.instaclass.classService.models.studentNote.*;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.repositories.StudentNoteRepository;
import com.clan.instaclass.classService.services.StudentNoteService;
import com.clan.instaclass.feign.instituteService.InstituteClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class StudentNoteServiceImpl implements StudentNoteService {
    private ClassRepository classRepository;
    private StudentNoteRepository studentNoteRepository;

    private InstituteClient instituteClient;
    @Override
    public CreateStudentNoteResponse create(CreateStudentNoteRequest request) throws StudentNoteNotValidException, StudentNoteExistException, ClassNotExistException {
        if (request.getNote() == null || request.getNote().isBlank() || request.getDate() == null || request.getTeacherId() == null || request.getTeacherId() <= 0 || request.getStudentId() == null || request.getStudentId() <= 0 || request.getClassId() == null){
            throw new StudentNoteNotValidException("Non hai inserito i dati correttamente");
        }
        StudentNoteEnt newStudentNoteEnt = new StudentNoteEnt();
        newStudentNoteEnt.setNote(request.getNote());
        newStudentNoteEnt.setDate(request.getDate());
        newStudentNoteEnt.setTeacher(request.getTeacherId());
        newStudentNoteEnt.setStudent(request.getStudentId());
        newStudentNoteEnt.setClassEnt(classRepository.getReferenceById(request.getClassId()));
        CreateStudentNoteResponse response = new CreateStudentNoteResponse();
        response.setId(studentNoteRepository.save(newStudentNoteEnt).getId());
        response.setNote(newStudentNoteEnt.getNote());
        response.setDate(newStudentNoteEnt.getDate());
        response.setTeacherId(newStudentNoteEnt.getTeacher());
        response.setStudentId(newStudentNoteEnt.getStudent());
        response.setClassId(newStudentNoteEnt.getClassEnt().getId());
        return response;
    }

    @Override
    public List<GetStudentNoteResponse> findAllStudentNotes(Integer id) throws StudentNoteNotExistException {
        if(id == null || id <= 0){
            throw new StudentNoteNotExistException("Hai inserito un id errato");
        }
        List<StudentNoteEnt> listStudentNoteEnt = studentNoteRepository.findAllStudentNote(id);
        if (listStudentNoteEnt.size() <= 0){
            throw new StudentNoteNotExistException("Non esiste nessuna nota studente per quella classe");
        }
        List<GetStudentNoteResponse> response = new ArrayList<>();
        for (StudentNoteEnt element : listStudentNoteEnt){
            GetStudentNoteResponse getAll = new GetStudentNoteResponse();
            getAll.setId(element.getId());
            getAll.setNote(element.getNote());
            getAll.setDate(element.getDate());
            getAll.setTeacherName(instituteClient.getTeacher(element.getTeacher()).getName());
            getAll.setStudentName(instituteClient.getStudent(element.getStudent()).getName());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public List<GetStudentNoteResponse> findAllStudentNotesByIdStudent(Integer idClass, Integer idStudent) throws StudentNoteNotValidException, StudentNoteNotExistException {
        if(idClass == null || idClass <= 0 || idStudent == null || idStudent <= 0 ){
            throw new StudentNoteNotValidException("Hai inserito un id errato");
        }
        List<StudentNoteEnt> listStudentNoteEnt = studentNoteRepository.findAllStudentNoteByIdStudent(idClass,idStudent);
        if (listStudentNoteEnt.size() <= 0){
            throw new StudentNoteNotExistException("Non esiste nessuna nota per lo studente di quella classe");
        }
        List<GetStudentNoteResponse> response = new ArrayList<GetStudentNoteResponse>();
        for (StudentNoteEnt element : listStudentNoteEnt) {
            GetStudentNoteResponse getAll = new GetStudentNoteResponse();
            getAll.setId(element.getId());
            getAll.setNote(element.getNote());
            getAll.setDate(element.getDate());
            getAll.setTeacherName(instituteClient.getTeacher(element.getTeacher()).getName());
            getAll.setStudentName(instituteClient.getStudent(element.getStudent()).getName());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public List<GetStudentNoteResponse> findAllStudentNotesByIdTeacher(Integer idClass, Integer idTeacher) throws StudentNoteNotValidException, StudentNoteNotExistException {
        if(idClass == null || idClass <= 0 || idTeacher == null || idTeacher <= 0 ){
            throw new StudentNoteNotExistException("Hai inserito un id errato");
        }
        List<StudentNoteEnt> listStudentNoteEnt = studentNoteRepository.findAllStudentNoteByIdTeacher(idClass,idTeacher);
        if (listStudentNoteEnt.size() <= 0){
            throw new StudentNoteNotExistException("Non esiste nessuna nota studente scritta da quel docente in quella classe");
        }
        List<GetStudentNoteResponse> response = new ArrayList<GetStudentNoteResponse>();
        for (StudentNoteEnt element : listStudentNoteEnt) {
            GetStudentNoteResponse getAll = new GetStudentNoteResponse();
            getAll.setId(element.getId());
            getAll.setNote(element.getNote());
            getAll.setDate(element.getDate());
            getAll.setTeacherName(instituteClient.getTeacher(element.getTeacher()).getName());
            getAll.setStudentName(instituteClient.getStudent(element.getStudent()).getName());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public PutStudentNoteResponse updateStudentNote(PutStudentNoteRequest request) throws StudentNoteNotValidException, StudentNoteNotExistException {
        if (request.getNote() != null && !request.getNote().isBlank() && request.getDate() != null && request.getTeacherId() != null && request.getTeacherId() > 0 && request.getStudentId() != null && request.getStudentId() > 0 && request.getClassId() != null){
            StudentNoteEnt studentNoteEnt = studentNoteRepository.findById(request.getId()).orElseThrow(() -> new StudentNoteNotExistException("Nota studente non trovata"));
            if (studentNoteEnt.getClassEnt().getId() != request.getClassId() && studentNoteEnt.getTeacher() != request.getTeacherId()){
                throw new StudentNoteNotValidException("Non sei autorizzato a modificare questa nota");
            }else {
                studentNoteEnt.setNote(request.getNote());
                studentNoteEnt.setDate(request.getDate());
                studentNoteEnt.setStudent(request.getStudentId());
                PutStudentNoteResponse response = new PutStudentNoteResponse();
                response.setId(studentNoteRepository.save(studentNoteEnt).getId());
                response.setNote(studentNoteEnt.getNote());
                response.setDate(studentNoteEnt.getDate());
                response.setStudentId(studentNoteEnt.getStudent());
                response.setTeacherId(studentNoteEnt.getTeacher());
                response.setClassId(studentNoteEnt.getClassEnt().getId());
                return response;
            }
        }else {
            throw new StudentNoteNotValidException("Non hai inserito i dati correttamente");
        }

    }

    @Override
    public void deleteStudentNote(DeleteStudentNoteRequest request) throws StudentNoteNotValidException, StudentNoteNotExistException {
        if (request.getId() != null && request.getId() > 0 && request.getTeacherId() != null && request.getTeacherId() > 0 && request.getStudentId() != null && request.getStudentId() > 0 && request.getClassId() != null) {
            StudentNoteEnt studentNoteEnt = studentNoteRepository.findById(request.getId()).orElseThrow(() -> new StudentNoteNotExistException("Nota studente non trovata"));
            if (studentNoteEnt.getClassEnt().getId() != request.getClassId() && studentNoteEnt.getTeacher() != request.getTeacherId()) {
                throw new StudentNoteNotValidException("Non sei autorizzato a modificare questa nota");
            } else {
                studentNoteRepository.delete(studentNoteEnt);
            }
        } else {
            throw new StudentNoteNotValidException("Non hai inserito i dati correttamente");
        }
    }
}
