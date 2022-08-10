package com.clan.instaclass.instituteService.services;

import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.institute.AlreadyExistingIstituteException;
import com.clan.instaclass.instituteService.exceptions.institute.InstituteNotFoundException;
import com.clan.instaclass.instituteService.models.institute.*;

import java.util.List;

public interface InstituteService {
    CreateInstituteResponse create(CreateInstituteRequest request) throws DataNonValidException, AlreadyExistingIstituteException;
    GetInstituteResponse get(Integer instituteId) throws InstituteNotFoundException;

    PutInstituteResponse put(PutInstituteRequest request) throws DataNonValidException, InstituteNotFoundException;

    void delete(Integer id) throws DataNonValidException,InstituteNotFoundException;

    List<GetAllInstituteResponse> getAll();


}
