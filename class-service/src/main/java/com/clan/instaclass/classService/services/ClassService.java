package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotValidException;
import com.clan.instaclass.classService.models.classes.CreateClassRequest;
import com.clan.instaclass.classService.models.classes.CreateClassResponse;
import com.clan.instaclass.classService.models.classes.GetClassResponse;

import java.util.List;

public interface ClassService {
    CreateClassResponse create(CreateClassRequest request) throws ClassNotValidException, ClassExistException;
    GetClassResponse get(Integer id) throws ClassNotExistException;

    List<ClassEnt> findAll();
}
