package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotValidException;

import java.util.List;

public interface ClassService {
    public List<ClassEnt> findAllClasses();
    public List<ClassEnt> findByName(Integer id) throws ClassNotValidException;
    public List<ClassEnt> findByNameContains(Integer id, String className)throws ClassNotValidException;
    public ClassEnt createNewClass(ClassEnt classEnt)throws ClassNotValidException, ClassNotExistException, ClassExistException;
    public ClassEnt fullClassUpdate(ClassEnt classEnt)throws ClassNotValidException, ClassNotExistException, ClassExistException;
    public void deleteById(Integer id)throws ClassNotValidException, ClassNotExistException;
}
