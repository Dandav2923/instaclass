package com.clan.instaclass.instituteService.services.impls;

import com.clan.instaclass.instituteService.entities.InstituteEnt;
import com.clan.instaclass.instituteService.exceptions.InstituteNotFoundException;
import com.clan.instaclass.instituteService.models.institute.CreateInstituteRequest;
import com.clan.instaclass.instituteService.models.institute.CreateInstituteResponse;
import com.clan.instaclass.instituteService.models.institute.GetInstituteResponse;
import com.clan.instaclass.instituteService.repositories.InstituteRepository;
import com.clan.instaclass.instituteService.services.InstituteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class InstituteServiceImpl implements InstituteService {
    private InstituteRepository instituteRepository;

    @Override
    public CreateInstituteResponse create(CreateInstituteRequest request) {
        InstituteEnt entity = new InstituteEnt();
        entity.setName(request.getName());
        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        CreateInstituteResponse response = new CreateInstituteResponse();
        response.setId(instituteRepository.save(entity).getId());
        return response;
    }

    @Override
    public GetInstituteResponse get(Integer instituteId) throws InstituteNotFoundException {
        GetInstituteResponse response = new GetInstituteResponse();
        InstituteEnt entity = instituteRepository.findById(instituteId).orElseThrow(InstituteNotFoundException::new);
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setUsername(entity.getUsername());
        return response;
    }
}
