package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.CommunicationEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.communication.CommunicationExistException;
import com.clan.instaclass.classService.exceptions.communication.CommunicationNotExistException;
import com.clan.instaclass.classService.exceptions.communication.CommunicationNotValidException;
import com.clan.instaclass.classService.models.communication.*;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.repositories.CommunicationRepository;
import com.clan.instaclass.classService.services.CommunicationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CommunicationServiceImpl implements CommunicationService {
    private CommunicationRepository communicationRepository;
    private ClassRepository classRepository;
    @Override
    public CreateCommunicationResponse create(CreateCommunicationRequest request) throws CommunicationNotValidException, CommunicationExistException, ClassNotExistException {
        if (request.getCommunication() == null || request.getCommunication().isBlank() || request.getDate() == null || request.getTeacherId() == null || request.getTeacherId() <= 0 || request.getClassId() == null){
            throw new CommunicationNotValidException("Non hai inserito i dati correttamente");
        }
            CommunicationEnt newCommunication = new CommunicationEnt();
            newCommunication.setCommunication(request.getCommunication());
            newCommunication.setDate(request.getDate());
            newCommunication.setTeacher(request.getTeacherId());
            newCommunication.setClassEnt(classRepository.getReferenceById(request.getClassId()));
            CreateCommunicationResponse response = new CreateCommunicationResponse();
            response.setId(communicationRepository.save(newCommunication).getId());
            response.setCommunication(newCommunication.getCommunication());
            response.setDate(newCommunication.getDate());
            response.setTeacherId(newCommunication.getTeacher());
            response.setClassId(newCommunication.getClassEnt().getId());
            return response;
    }

    @Override
    public List<GetCommunicationResponse> findAllCommunications(Integer id) throws CommunicationNotValidException {
        if (id == null || id <= 0 ){
            throw new CommunicationNotValidException("Hai inserito un id non valido");
        }
        List<CommunicationEnt> listCommunicationEnt = communicationRepository.findCommunications(id);
        List<GetCommunicationResponse> response = new ArrayList<GetCommunicationResponse>();
        for (CommunicationEnt element : listCommunicationEnt){
            GetCommunicationResponse getAll= new GetCommunicationResponse();
            getAll.setCommunication(element.getCommunication());
            getAll.setDate(element.getDate());
            getAll.setTeacherId(element.getTeacher());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public PutCommunicationResponse updateCommunication(PutCommunicationRequest request) throws CommunicationNotValidException, CommunicationNotExistException {
        if (request.getCommunication() != null && !request.getCommunication().isBlank() && request.getDate() != null && request.getTeacherId() != null && request.getTeacherId() > 0 && request.getClassId() != null){
            CommunicationEnt communicationEnt = communicationRepository.findById(request.getId()).orElseThrow(() -> new CommunicationNotExistException("Comunicazione non trovata"));
            if (communicationEnt.getClassEnt().getId() != request.getClassId() && communicationEnt.getTeacher() != request.getTeacherId()){
                throw new CommunicationNotValidException("Non sei autorizzato a mofificare questa comunicazione");
            }else {
                communicationEnt.setCommunication(request.getCommunication());
                communicationEnt.setDate(request.getDate());
                PutCommunicationResponse response = new PutCommunicationResponse();
                response.setId(communicationRepository.save(communicationEnt).getId());
                response.setCommunication(communicationEnt.getCommunication());
                response.setDate(communicationEnt.getDate());
                response.setTeacherId(communicationEnt.getTeacher());
                response.setClassId(communicationEnt.getClassEnt().getId());
                return response;
            }
        }else {
            throw new CommunicationNotValidException("Non hai inserito i dati correttamente");
        }
    }

    @Override
    public void deleteCommunication(DeleteCommunicationRequest request) throws CommunicationNotValidException, CommunicationNotExistException {
        if ( request.getTeacherId() != null && request.getTeacherId() > 0 && request.getClassId() != null) {
            CommunicationEnt communicationEnt = communicationRepository.findById(request.getId()).orElseThrow(() -> new CommunicationNotExistException("Comunicazione non trovata"));
            if (communicationEnt.getClassEnt().getId() != request.getClassId() && communicationEnt.getTeacher() != request.getTeacherId()){
                throw new CommunicationNotValidException("Non sei autorizzato a mofificare questa comunicazione");
            }else {
                communicationRepository.delete(communicationEnt);
            }
        }else {
            throw new CommunicationNotValidException("Non hai inserito i dati correttamente");
        }
    }
}
