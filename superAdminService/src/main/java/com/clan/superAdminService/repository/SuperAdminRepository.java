package com.clan.superAdminService.repository;

import com.clan.superAdminService.entity.SuperAdmin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuperAdminRepository extends MongoRepository<SuperAdmin,Integer> {

}
