package com.clan.superAdmin.service;

import com.clan.superAdmin.exception.DataNotValidException;
import com.clan.superAdmin.exception.SuperAdminAlreadyExistingException;
import com.clan.superAdmin.models.CreateSuperAdminRequest;
import com.clan.superAdmin.models.CreateSuperAdminResponse;

public interface SuperAdminService {
    CreateSuperAdminResponse create(CreateSuperAdminRequest request) throws DataNotValidException, SuperAdminAlreadyExistingException;
}
