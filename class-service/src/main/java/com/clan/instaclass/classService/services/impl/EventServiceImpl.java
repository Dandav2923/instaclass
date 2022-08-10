package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.EventEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.communication.CommunicationNotValidException;
import com.clan.instaclass.classService.exceptions.event.EventExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotValidException;
import com.clan.instaclass.classService.models.event.*;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.repositories.EventRepository;
import com.clan.instaclass.classService.services.EventService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClassRepository classRepository;
    @Override
    public CreateEventResponse create(CreateEventRequest request) throws EventNotValidException, EventExistException, ClassExistException {
        if (request.getName() == null || request.getName().isBlank() ||request.getDescription() == null || request.getDescription().isBlank() || request.getDate() == null || request.getClassId() == null){
            throw new EventNotValidException("Non hai inserito i dati correttamente");
        }
        EventEnt newEvent = new EventEnt();
        newEvent.setName(request.getName());
        newEvent.setDescription(request.getDescription());
        newEvent.setDate(request.getDate());
        newEvent.setClassEnt(classRepository.getReferenceById(request.getClassId()));
        CreateEventResponse response = new CreateEventResponse();
        response.setId(eventRepository.save(newEvent).getId());
        response.setName(newEvent.getName());
        response.setDescription(newEvent.getDescription());
        response.setDate(newEvent.getDate());
        response.setClassId(newEvent.getClassEnt().getId());
        return response;
    }

    @Override
    public List<GetEventResponse> findAllEvents(Integer id) throws EventNotValidException {
        if (id == null || id <= 0 ){
            throw new EventNotValidException("Hai inserito un id non valido");
        }
        List<EventEnt> listEventEnt = eventRepository.findEvents(id);
        List<GetEventResponse> response = new ArrayList<GetEventResponse>();
        for (EventEnt element : listEventEnt){
            GetEventResponse getAll = new GetEventResponse();
            getAll.setId(element.getId());
            getAll.setName(element.getName());
            getAll.setDescription(element.getDescription());
            getAll.setDate(element.getDate());
            getAll.setClassId(element.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public PutEventResponse updateEvent(PutEventRequest request) throws EventNotValidException, EventNotExistException {
        if (request.getName() != null && !request.getName().isBlank() && request.getDescription() != null && !request.getDescription().isBlank() && request.getDate() != null && request.getClassId() != null){
            EventEnt eventEnt = eventRepository.findById(request.getId()).orElseThrow(()-> new EventNotExistException("Evento non trovato"));
            if(eventEnt.getClassEnt().getId() != request.getClassId()){
                throw new EventNotValidException("Non sei autorizzato a modificare questo evento");
            }else{
                eventEnt.setName(request.getName());
                eventEnt.setDescription(request.getDescription());
                eventEnt.setDate(request.getDate());
                PutEventResponse response = new PutEventResponse();
                response.setName(eventRepository.save(eventEnt).getName());
                response.setDescription(eventEnt.getDescription());
                response.setDate(eventEnt.getDate());
                response.setClassId(eventEnt.getClassEnt().getId());
                return response;
            }
        }else {
            throw new EventNotValidException("Non hai inserito i dati correttamente");
        }
    }

    @Override
    public void deleteEvent(DeleteEventRequest request) throws EventNotValidException, EventNotExistException {
        if (request.getClassId() != null && request.getId() != null && request.getId() > 0){
            EventEnt eventEnt = eventRepository.findById(request.getId()).orElseThrow(()-> new EventNotExistException("Evento non trovato"));
            if(eventEnt.getClassEnt().getId() != request.getClassId()){
                throw new EventNotValidException("Non sei autorizzato a eliminare questo evento");
            }else {
                eventRepository.delete(eventEnt);
            }
        }else {
            throw new EventNotValidException("Non hai inserito i dati correttamente");
        }
    }
}
