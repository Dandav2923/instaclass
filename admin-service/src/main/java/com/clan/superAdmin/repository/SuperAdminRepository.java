package com.clan.superAdmin.repository;

import com.clan.superAdmin.entity.SuperAdmin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuperAdminRepository extends MongoRepository<SuperAdmin,Integer> {

}
