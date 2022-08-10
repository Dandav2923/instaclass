package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceNotExistException;
import com.clan.instaclass.classService.exceptions.presence.PresenceNotValidException;
import com.clan.instaclass.classService.models.presence.*;

import java.util.List;

public interface PresenceService {
    CreatePresenceResponse create(CreatePresenceRequest request) throws PresenceNotValidException, PresenceExistException, ClassNotExistException;
    List<GetPresenceResponse> findAllPresences(Integer id) throws PresenceNotValidException;
    List<GetPresenceResponse> findAllPresencesByStudent(Integer idClass, Integer idStudent) throws PresenceNotValidException, PresenceNotExistException;
    PutPresenceResponse updatePresence(PutPresenceRequest request) throws PresenceNotValidException, PresenceNotExistException;
    void deletePresence(DeletePresenceRequest request) throws  PresenceNotValidException, PresenceNotExistException;
}
