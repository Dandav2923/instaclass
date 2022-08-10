package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.PresenceEnt;
import com.clan.instaclass.classService.exceptions.classNote.ClassNoteNotExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceNotExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceNotValidException;
import com.clan.instaclass.classService.models.presence.*;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.repositories.PresenceRepository;
import com.clan.instaclass.classService.services.PresenceService;

import java.util.ArrayList;
import java.util.List;

public class PresenceServiceImpl implements PresenceService {
    private ClassRepository classRepository;
    private PresenceRepository presenceRepository;
    @Override
    public CreatePresenceResponse create(CreatePresenceRequest request) throws PresenceNotValidException, PresenceExistException, ClassNotExistException {
        if (request.getPresent() == null || request.getDate() == null || request.getStudentId() == null || request.getStudentId() <= 0 || request.getClassId() <= 0){
            throw new PresenceNotValidException("Non hai inserito i dati correttamente");
        }
        PresenceEnt newPresenceEnt = new PresenceEnt();
        newPresenceEnt.setPresent(request.getPresent());
        newPresenceEnt.setDate(request.getDate());
        newPresenceEnt.setStudent(request.getStudentId());
        newPresenceEnt.setClassEnt(classRepository.getReferenceById(request.getClassId()));
        CreatePresenceResponse response = new CreatePresenceResponse();
        response.setId(presenceRepository.save(newPresenceEnt).getId());
        response.setPresent(newPresenceEnt.getPresent());
        response.setDate(newPresenceEnt.getDate());
        response.setStudentId(newPresenceEnt.getStudent());
        response.setClassId(newPresenceEnt.getClassEnt().getId());
        return response;
    }

    @Override
    public List<GetPresenceResponse> findAllPresences(Integer id) throws PresenceNotValidException {
        if(id == null || id <= 0){
            throw new PresenceNotValidException("Hai inserito un id non valido");
        }
        List<PresenceEnt> listPresenceEnt = presenceRepository.findPresences(id);
        List<GetPresenceResponse> response = new ArrayList<GetPresenceResponse>();
        for (PresenceEnt element : listPresenceEnt){
            GetPresenceResponse getAll = new GetPresenceResponse();
            getAll.setId(element.getId());
            getAll.setPresent(element.getPresent());
            getAll.setDate(element.getDate());
            getAll.setStudentId(element.getStudent());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public List<GetPresenceResponse> findAllPresencesByStudent(Integer classId, Integer studentId) throws PresenceNotValidException, PresenceNotExistException {
        if (classId == null || classId <= 0 || studentId == null || studentId <= 0 ){
            throw new PresenceNotValidException("Hai inserito l'id della classe o dello studente non validi");
        }
        List<PresenceEnt> listPresenceEnt = presenceRepository.findPresencesByStudent(classId, studentId);
        if (listPresenceEnt.size() <= 0 ){
            throw new PresenceNotExistException("Non esiste nessuna presenza per questo studente");
        }
        List<GetPresenceResponse> response = new ArrayList<GetPresenceResponse>();
        for (PresenceEnt element : listPresenceEnt){
            GetPresenceResponse getAll = new GetPresenceResponse();
            getAll.setId(element.getId());
            getAll.setPresent(element.getPresent());
            getAll.setDate(element.getDate());
            getAll.setStudentId(element.getStudent());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public PutPresenceResponse updatePresence(PutPresenceRequest request) throws PresenceNotValidException, PresenceNotExistException {
        if (request.getPresent() != null && request.getDate() != null && request.getStudentId() != null && request.getStudentId() > 0 && request.getClassId() > 0){
            PresenceEnt presenceEnt = presenceRepository.findById(request.getId()).orElseThrow(() -> new PresenceNotExistException("Presenza non trovata"));
            if (presenceEnt.getClassEnt().getId() != request.getClassId() && presenceEnt.getStudent() != request.getStudentId()){
                throw new PresenceNotValidException("Non sei autorizzato a vedere questa presenza");
            }else{
                presenceEnt.setPresent(request.getPresent());
                presenceEnt.setDate(request.getDate());
                PutPresenceResponse response = new PutPresenceResponse();
                response.setId(presenceRepository.save(presenceEnt).getId());
                response.setPresent(presenceEnt.getPresent());
                response.setDate(presenceEnt.getDate());
                response.setStudentId(presenceEnt.getStudent());
                response.setClassId(presenceEnt.getClassEnt().getId());
                return response;
            }
        }else{
            throw new PresenceNotValidException("Non hai inserito i dati correttamente");
        }

    }

    @Override
    public void deletePresence(DeletePresenceRequest request) throws PresenceNotValidException, PresenceNotExistException {
        if (request.getId() != null && request.getId() > 0 && request.getStudentId() != null && request.getStudentId()> 0 && request.getClassId() != null){
            PresenceEnt presenceEnt = presenceRepository.findById(request.getId()).orElseThrow(() -> new PresenceNotExistException("Presenza non trovata"));
            if (presenceEnt.getClassEnt().getId() != request.getClassId() && presenceEnt.getStudent() != request.getStudentId()){
                throw new PresenceNotValidException("Non sei autorizzato a vedere questa presenza");
            }else {
                presenceRepository.delete(presenceEnt);
            }
        }else {
            throw new PresenceNotValidException("Non hai inserito i dati correttamente");
        }
    }
}
