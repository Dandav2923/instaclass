package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotValidException;
import com.clan.instaclass.classService.models.classes.*;

import java.util.List;

public interface ClassService {
    CreateClassResponse create(CreateClassRequest request) throws ClassNotValidException, ClassExistException;
    List<GetClassResponse> findAll(Integer id);
    PutClassResponse updateClass(PutClassRequest request) throws ClassNotValidException, ClassNotExistException;
    void deleteClass(DeleteClassRequest request) throws ClassNotValidException, ClassNotExistException;
}
