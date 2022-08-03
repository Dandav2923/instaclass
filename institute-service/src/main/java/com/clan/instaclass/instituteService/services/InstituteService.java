package com.clan.instaclass.instituteService.services;

import com.clan.instaclass.instituteService.exceptions.InstituteNotFoundException;
import com.clan.instaclass.instituteService.models.institute.CreateInstituteRequest;
import com.clan.instaclass.instituteService.models.institute.CreateInstituteResponse;
import com.clan.instaclass.instituteService.models.institute.GetInstituteResponse;

public interface InstituteService {
    CreateInstituteResponse create(CreateInstituteRequest request);
    GetInstituteResponse get(Integer instituteId) throws InstituteNotFoundException;
}
