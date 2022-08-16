package com.clan.superAdmin.service.impl;

import com.clan.superAdmin.entities.SuperAdmin;
import com.clan.superAdmin.exception.DataNotValidException;
import com.clan.superAdmin.exception.SuperAdminAlreadyExistingException;
import com.clan.superAdmin.models.CreateSuperAdminRequest;
import com.clan.superAdmin.models.CreateSuperAdminResponse;
import com.clan.superAdmin.repository.SuperAdminRepository;
import com.clan.superAdmin.service.SuperAdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class SuperAdminServiceImpl implements SuperAdminService {

    private SuperAdminRepository superAdminRepository;

    @Override
    public CreateSuperAdminResponse create(CreateSuperAdminRequest request) throws DataNotValidException, SuperAdminAlreadyExistingException {
        if (request.getPassword() == null || request.getUsername() == null){
            throw new DataNotValidException("Non hai inserito i dati correttamente");
        }
        if (superAdminRepository.findByUsername(request.getUsername()) == null) {
            SuperAdmin entity = new SuperAdmin();
            entity.setPassword(request.getPassword());
            entity.setUsername(request.getUsername());
            superAdminRepository.save(entity);
            CreateSuperAdminResponse response = new CreateSuperAdminResponse();
            response.setPassword(request.getPassword());
            response.setUsername(request.getUsername());
            return response;

        }
        else{
            throw new SuperAdminAlreadyExistingException("super admin gia esistente");
        }
    }
}
