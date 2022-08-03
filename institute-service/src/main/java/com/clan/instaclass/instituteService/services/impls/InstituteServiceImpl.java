package com.clan.instaclass.instituteService.services.impls;

import com.clan.instaclass.instituteService.entities.InstituteEnt;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.institute.AlreadyExistingIstituteException;
import com.clan.instaclass.instituteService.exceptions.institute.InstituteNotFoundException;
import com.clan.instaclass.instituteService.models.institute.*;
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
    public CreateInstituteResponse create(CreateInstituteRequest request) throws DataNonValidException, AlreadyExistingIstituteException {
        if (request.getName() == null || request.getPassword() == null) {
            throw new DataNonValidException("dati mancanti");
        }
        if (instituteRepository.findByName(request.getName()) == null) {
            InstituteEnt entity = new InstituteEnt();
            entity.setName(request.getName());
            entity.setPassword(request.getPassword());
            CreateInstituteResponse response = new CreateInstituteResponse();
            response.setId(instituteRepository.save(entity).getId());
            return response;
        }
        else{
            throw new AlreadyExistingIstituteException("istituto gia esistente");
        }

    }

    @Override
    public GetInstituteResponse get(Integer instituteId) throws InstituteNotFoundException {
        GetInstituteResponse response = new GetInstituteResponse();
        InstituteEnt entity = instituteRepository.findById(instituteId).orElseThrow(() -> new InstituteNotFoundException("istituto non trovato"));
        response.setId(entity.getId());
        response.setName(entity.getName());
        return response;
    }

    public PutInstituteResponse put(PutInstituteRequest request) throws DataNonValidException, InstituteNotFoundException {
        if (request.getName() == null || request.getPassword() == null || request.getId() == null) {
            throw new DataNonValidException("dati mancanti");
        }

        InstituteEnt entity = instituteRepository.findById(request.getId()).orElseThrow(() -> new InstituteNotFoundException("istituto non trovato"));

        if (entity == null) {
            throw new InstituteNotFoundException("istituto non trovato");
        }
        entity.setName(request.getName());
        entity.setPassword(request.getPassword());
        PutInstituteResponse response = new PutInstituteResponse();
        response.setId(instituteRepository.save(entity).getId());
        return response;
    }

    public void delete(Integer request) throws DataNonValidException,InstituteNotFoundException {
        if (request == null || request < 1) {
            throw new DataNonValidException("dati mancanti");
        }
        InstituteEnt enitity = instituteRepository.findById(request).orElseThrow(()->new InstituteNotFoundException("istituto non trovato"));

        instituteRepository.deleteById(request);

    }

}
