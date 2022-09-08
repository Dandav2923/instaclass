package com.clan.instaclass.instituteService.services.impls;


import com.clan.instaclass.feign.instituteService.models.institute.*;
import com.clan.instaclass.instituteService.entities.InstituteEnt;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.institute.AlreadyExistingIstituteException;
import com.clan.instaclass.instituteService.exceptions.institute.InstituteNotFoundException;
import com.clan.instaclass.instituteService.models.institute.*;
import com.clan.instaclass.instituteService.repositories.InstituteRepository;
import com.clan.instaclass.instituteService.services.InstituteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class InstituteServiceImpl implements InstituteService {
    private InstituteRepository instituteRepository;

    private PasswordEncoder passwordEncoder;

    @Override
    public CreateInstituteResponse create(CreateInstituteRequest request) throws DataNonValidException, AlreadyExistingIstituteException {
        if (request.getName() == null || request.getPassword() == null || request.getUsername() == null) {
            throw new DataNonValidException("dati mancanti");
        }
        if (instituteRepository.findByUsername(request.getUsername()) == null) {
            InstituteEnt entity = new InstituteEnt();
            entity.setName(request.getName());
            entity.setPassword(passwordEncoder.encode(request.getPassword()));
            System.out.println(passwordEncoder.encode(request.getPassword()));
            entity.setUsername(request.getUsername());
            CreateInstituteResponse response = new CreateInstituteResponse();
            response.setId(instituteRepository.save(entity).getId());
            return response;
        }
        else{
            throw new AlreadyExistingIstituteException("istituto gia esistente");
        }

    }

    /*
    @Override
    public LoginInstituteResponse login (LoginInstituteRequest request) throws DataNonValidException, InstituteNotFoundException, PasswordNotValidException {
        if (request.getUsername() == null || request.getPassword() == null) {
            throw new DataNonValidException("dati mancanti");
        }
        InstituteEnt instituteEnt = instituteRepository.findByUsername(request.getUsername());
        if (instituteEnt != null) {
            if (passwordEncoder.matches(request.getPassword(), instituteEnt.getPassword())) {
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                String accessToken = JWT.create()
                        .withSubject(request.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                        .sign(algorithm);
                LoginInstituteResponse response = new LoginInstituteResponse();
                response.setUsername(request.getUsername());
                response.setToken(accessToken);
                return response;
            }
            else{
                throw new PasswordNotValidException("password non valida");
            }
        }
        else{
            throw new InstituteNotFoundException("istituto non trovato");
        }
    }

     */

    @Override
    public GetInstituteResponse get(Integer instituteId) throws InstituteNotFoundException {
        GetInstituteResponse response = new GetInstituteResponse();
        InstituteEnt entity = instituteRepository.findById(instituteId).orElseThrow(() -> new InstituteNotFoundException("istituto non trovato"));
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setUsername(entity.getUsername());
        return response;
    }

    @Override
    public GetInstituteResponse getUsername(String instituteUsername) throws InstituteNotFoundException {
        GetInstituteResponse response = new GetInstituteResponse();
        InstituteEnt entity = instituteRepository.findByUsername(instituteUsername);
        if (entity == null) {
            throw new InstituteNotFoundException("istituto non trovato");
        }
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setUsername(entity.getUsername());
        return response;
    }

    public PutInstituteResponse put(PutInstituteRequest request) throws DataNonValidException, InstituteNotFoundException {
        if (request.getName() == null || request.getPassword() == null || request.getId() == null || request.getUsername() == null) {
            throw new DataNonValidException("dati mancanti");
        }

        InstituteEnt entity = instituteRepository.findById(request.getId()).orElseThrow(() -> new InstituteNotFoundException("istituto non trovato"));

        entity.setName(request.getName());
        entity.setPassword(request.getPassword());
        entity.setUsername(request.getUsername());
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

    @Override
    public List<GetAllInstituteResponse> getAll() {
        List<InstituteEnt> entity = instituteRepository.findAll();
        List<GetAllInstituteResponse> response = new ArrayList<GetAllInstituteResponse>();
        for (InstituteEnt subject : entity){
            GetAllInstituteResponse getAll = new GetAllInstituteResponse();
            getAll.setId(subject.getId());
            getAll.setName(subject.getName());
            getAll.setUsername(subject.getUsername());
            response.add(getAll);
        }
        return response;
    }



}
