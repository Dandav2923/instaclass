package com.clan.superAdmin.repository;

import com.clan.superAdmin.entities.SuperAdmin;
import com.clan.superAdmin.models.CreateSuperAdminRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuperAdminRepository extends MongoRepository<SuperAdmin,Integer> {

    public SuperAdmin findByUsername(String username);

}
