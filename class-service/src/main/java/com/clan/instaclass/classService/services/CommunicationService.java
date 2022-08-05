package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.communication.CommunicationExistException;
import com.clan.instaclass.classService.exceptions.communication.CommunicationNotExistException;
import com.clan.instaclass.classService.exceptions.communication.CommunicationNotValidException;
import com.clan.instaclass.classService.models.classes.PutClassResponse;
import com.clan.instaclass.classService.models.communication.*;

import java.util.List;

public interface CommunicationService {
    CreateCommunicationResponse create(CreateCommunicationRequest request) throws CommunicationNotValidException, CommunicationExistException;
    List<GetCommunicationResponse> findAllCommunications(Integer id) throws CommunicationNotValidException;
    PutCommunicationResponse updateCommunication(PutCommunicationRequest request) throws CommunicationNotValidException, CommunicationNotExistException;
    void deleteCommunication(DeleteCommunicationRequest request) throws CommunicationNotValidException, CommunicationNotExistException;
}
