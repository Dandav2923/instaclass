package com.clan.classe.service;

import com.clan.classe.entity.Classe;
import com.clan.classe.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClasseService {
    @Autowired
    private ClasseRepository classRepository;
    // metoto per trovare tutte le classi nel db
    public List<Classe> findAllClasses(){
        return classRepository.findAll();
    }

    // metodo per trovare una classe in base all'id
    public Classe findById(Integer id ){
        if(id == null){
            System.out.println("non è stato fornito l'id");
        }
        return classRepository.findById(id).orElse(null);
    }

    // metodo per trovare uno a più classi per l'id isituto
    public List<Classe> findByNomeClasseContains(Integer id) {
        if (id == null && id == 0){
            System.out.println("non hai inserito correttamente l'id dell'istituto");
        }
        return classRepository.findByClassName(id);
    }

    // metodo per trovare il nome della classe di un istituto
    public List<Classe> findByClassNameContains(Integer id, String className){
        if (id == null && className == null & className == ""){
            System.out.println("i dati forniti non sono corretti");
        }
        return classRepository.findByClassNameContains(id, className);
    }

    // creare una nuova classe (dedicato soltanto all'account istituto)
    public Classe createNewClass(Classe classe){
        if(classe.getClassName() == null || classe.getClassName().isBlank()){
            System.out.println("è stata fornita una classe con dati incompleti");
        }
        return classRepository.save(classe);
    }

    // update completo della classe (dedicato soltanto all'account istituto)
    public Classe fullyClassUpdate(Classe classe) {
        if (classe.getId() == null ){
            System.out.println("non è stato fornito l'id");
        }
        Classe classeDb = classRepository.findById(classe.getId()).orElse(null);
        if(classeDb == null ){
            System.out.println("La classe con il nome: " + classe.getClassName() + "non esiste");
        }
        classeDb.setClassName(classe.getClassName());
        classeDb.setIstituteFk(classe.getIstituteFk());
        return classeDb;
    }

    // metodo per cancellare per id una classe
    public void deleteById(Integer id){
        Classe classeDb = classRepository.findById(id).orElse(null);
        if( classeDb == null ){
            System.out.println("La classe con il nome: " + id + "non esiste");
        }
        classRepository.deleteById(id);
    }

    //metodo per cancellare una classe tramite il nome ma solo di quell'istituto
    public void deleteByClassName(Integer id, String className){
        if (id == null && className == "" || className == null){
            System.out.println("Non hai fornito le informazioni necessarie per la cancellazione");
        }
        classRepository.deleteByClassName(id, className);
    }
}
