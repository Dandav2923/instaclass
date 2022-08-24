package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.HomeworkEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotValidException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkNotExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkNotValidException;
import com.clan.instaclass.classService.models.event.GetEventResponse;
import com.clan.instaclass.classService.models.homework.*;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.repositories.HomeworkRepository;
import com.clan.instaclass.classService.services.HomeworkService;
import com.clan.instaclass.feign.instituteService.InstituteClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class HomeworkServiceImpl implements HomeworkService {
    private ClassRepository classRepository;
    private HomeworkRepository homeworkRepository;

    private InstituteClient instituteClient;
    @Override
    public CreateHomeworkResponse create(CreateHomeworkRequest request) throws HomeworkExistException, HomeworkNotValidException, ClassExistException {
        if (request.getAssignment() == null || request.getAssignment().isBlank() || request.getDate() == null || request.getSubjectId() == null || request.getSubjectId() <= 0 || request.getClassId() == null){
            throw new HomeworkNotValidException("Non hai inserito i dati correttamente");
        }
        HomeworkEnt newHomeworkEnt = new HomeworkEnt();
        newHomeworkEnt.setAssignment(request.getAssignment());
        newHomeworkEnt.setDueDate(request.getDate());
        newHomeworkEnt.setSubject(request.getSubjectId());
        newHomeworkEnt.setClassEnt(classRepository.getReferenceById(request.getClassId()));
        CreateHomeworkResponse response = new CreateHomeworkResponse();
        response.setId(homeworkRepository.save(newHomeworkEnt).getId());
        response.setAssignment(newHomeworkEnt.getAssignment());
        response.setDate(newHomeworkEnt.getDueDate());
        response.setSubjectId(newHomeworkEnt.getSubject());
        response.setClassId(newHomeworkEnt.getClassEnt().getId());
        return response;
    }

    @Override
    public List<GetHomeworkResponse> findAllHomeworks(Integer id) throws HomeworkNotValidException {
        if (id == null || id <= 0 ){
            throw new HomeworkNotValidException("Hai inserito un id non valido");
        }
        List<HomeworkEnt> listHomeworkEnt = homeworkRepository.findHomeworks(id);
        List<GetHomeworkResponse> response = new ArrayList<GetHomeworkResponse>();
        for (HomeworkEnt element : listHomeworkEnt){
            GetHomeworkResponse getAll = new GetHomeworkResponse();
            getAll.setId(element.getId());
            getAll.setAssignment(element.getAssignment());
            getAll.setDate(element.getDueDate());
            getAll.setSubjectName(instituteClient.getSubjectById(element.getSubject()).getName());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public PutHomeworkResponse updateHomework(PutHomeworkRequest request) throws HomeworkNotValidException, HomeworkNotExistException {
        if (request.getAssignment() != null && !request.getAssignment().isBlank() && request.getDate() != null && request.getSubjectId() != null && request.getSubjectId() > 0 && request.getClassId() != null){
            HomeworkEnt homeworkEnt = homeworkRepository.findById(request.getId()).orElseThrow(()-> new HomeworkNotExistException("Compito non trovato"));
            if (homeworkEnt.getClassEnt().getId() != request.getClassId()){
                throw new HomeworkNotValidException("Non sei autorizzato a modificare questo compito");
            }else {
                homeworkEnt.setAssignment(request.getAssignment());
                homeworkEnt.setDueDate(request.getDate());
                homeworkEnt.setSubject(request.getSubjectId());
                PutHomeworkResponse response = new PutHomeworkResponse();
                response.setId(homeworkRepository.save(homeworkEnt).getId());
                response.setAssignment(homeworkEnt.getAssignment());
                response.setDate(homeworkEnt.getDueDate());
                response.setSubjectId(homeworkEnt.getSubject());
                response.setClassId(homeworkEnt.getClassEnt().getId());
                return response;
            }
        }else {
            throw new HomeworkNotValidException("Non hai inserito i dati correttamente");
        }
    }

    @Override
    public void deleteHomework(DeleteHomeworkRequest request) throws HomeworkNotValidException, HomeworkNotExistException {
        if (request.getClassId() != null && request.getId() != null && request.getId() > 0){
            HomeworkEnt homeworkEnt = homeworkRepository.findById(request.getId()).orElseThrow(()-> new HomeworkNotExistException("Compito non trovato"));
            if (homeworkEnt.getClassEnt().getId() != request.getClassId()){
                throw new HomeworkNotValidException("Non sei autorizzato a eliminare questo compito");
            }else{
                homeworkRepository.delete(homeworkEnt);
            }
        }else{
            throw new HomeworkNotValidException("Non hai inserito i dati correttamente");
        }

    }
}
