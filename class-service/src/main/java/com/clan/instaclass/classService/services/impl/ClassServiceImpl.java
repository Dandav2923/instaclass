package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.classes.ClassNotValidException;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;
    // metoto per trovare tutte le classi nel db
    @Override
    public List<ClassEnt> findAllClasses() {
        return classRepository.findAll();
    }


    // metodo per trovare una classe in base all'id
    public ClassEnt findById(Integer id) throws ClassNotValidException {
        if (id == null && id <= 0) {
            throw new ClassNotValidException("Hai inserito un id sbagliato");
        }
        return classRepository.findById(id).orElse(null);
    }
    //metodo per trovare uno a più classi per l'id isituto
    @Override
    public List<ClassEnt> findByName(Integer id) throws ClassNotValidException {
        if (id == null && id <= 0) {
            throw new ClassNotValidException("Hai inserito un id sbagliato");
        }
        return classRepository.findByName(id);
    }
    //metodo per trovare una o più classi del tuo istituto
    @Override
    public List<ClassEnt> findByNameContains(Integer id, String className) throws ClassNotValidException {
        if (id == null && id <= 0 && className == null && className.isBlank()) {
            throw new ClassNotValidException("Hai inserito dei dati sbagliati");
        }
        return classRepository.findByNameContains(id,className);
    }
    //metodo per creare una nuova classe nell'istituto
    @Override
    public ClassEnt createNewClass(ClassEnt classEnt) throws ClassNotValidException, ClassExistException {
        if (classEnt.getName() == null || classEnt.getName().isBlank() && classEnt.getInstitute() == null || classEnt.getInstitute() <= 0){
            throw new ClassNotValidException("è stata fornita una classe con dati incompleti");
        }
        //controllo se è presente la classe nel db
        if (classEnt.getName() != null){
            throw new ClassExistException("Esiste già una classe con questo nome nel tuo istituto");
        }
        return classRepository.save(classEnt);
    }

    @Override
    public ClassEnt fullClassUpdate(ClassEnt classEnt) throws ClassNotValidException, ClassNotExistException{
        if (classEnt.getName() == null || classEnt.getName().isBlank() && classEnt.getInstitute() == null || classEnt.getInstitute() <= 0){
            throw new ClassNotValidException("è stata fornita una classe con dati incompleti");
        }
        ClassEnt updateClassEnt = classRepository.findById(classEnt.getId()).orElse(null);
        if (updateClassEnt == null){
            throw new ClassNotExistException("La classe con id:" + classEnt.getId() + "non esiste");
        }
        classEnt.setName(classEnt.getName());
        return updateClassEnt;
    }

    @Override
    public void deleteById(Integer id) throws ClassNotValidException, ClassNotExistException{
        ClassEnt deleteClassEnt = classRepository.findById(id).orElse(null);
        if (deleteClassEnt == null){
            throw new ClassNotExistException("La classe con id: " + id + " non esiste");
        }
        classRepository.deleteById(id);
    }
}
