package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.event.EventExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotExistException;
import com.clan.instaclass.classService.exceptions.event.EventNotValidException;
import com.clan.instaclass.classService.models.event.*;

import java.util.List;

public interface EventService {
    CreateEventResponse create(CreateEventRequest request) throws EventNotValidException, EventExistException, ClassExistException;
    List<GetEventResponse> findAllEvents(Integer id) throws EventNotValidException;
    PutEventResponse updateEvent(PutEventRequest request) throws EventNotValidException, EventNotExistException;
    void deleteEvent(DeleteEventRequest request)throws EventNotValidException, EventNotExistException;
}
