package com.clan.instaclass.instituteService.services.impls;

import com.clan.instaclass.feign.instituteService.models.student.*;
import com.clan.instaclass.instituteService.entities.StudentEnt;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.student.StudentAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.student.StudentNotFoundException;
import com.clan.instaclass.instituteService.repositories.InstituteRepository;
import com.clan.instaclass.instituteService.repositories.StudentRepository;
import com.clan.instaclass.instituteService.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService{

    private InstituteRepository instituteRepository;

    private StudentRepository studentRepository;



    @Override
    public CreateStudentResponse create(CreateStudentRequest request) throws DataNonValidException, StudentAlreadyExistingException {
        if (request.getName() == null ||
                request.getInstituteId() < 1 ||
                request.getFiscalCode() == null ||
                request.getFiscalCode().length() != 16 ||
                request.getSurname() == null ||
                request.getUsername() == null ||
                request.getPassword() == null
        ) {
            throw new DataNonValidException("dati mancanti");
        }
        List<StudentEnt> students = studentRepository.getAllStudentByInstitute(request.getInstituteId());

        for(StudentEnt student : students) {
            if (student.getUsername().equalsIgnoreCase(request.getUsername()) || student.getFiscalCode().equalsIgnoreCase(request.getFiscalCode()))
            {
                throw new StudentAlreadyExistingException("studente gia esistente");
            }
        }
        StudentEnt entity = new StudentEnt();
        entity.setName(request.getName());
        entity.setUsername(request.getUsername());
        entity.setFiscalCode(request.getFiscalCode());
        entity.setSurname(request.getSurname());
        entity.setPassword(request.getPassword());
        entity.setInstitute(instituteRepository.getReferenceById(request.getInstituteId()));
        CreateStudentResponse response = new CreateStudentResponse();
        response.setId(studentRepository.save(entity).getId());
        return response;
    }


    @Override
    public GetStudentResponse get(Integer studentId) throws StudentNotFoundException {
        StudentEnt entity = studentRepository.findById(studentId).orElseThrow(StudentNotFoundException::new);
        GetStudentResponse response = new GetStudentResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSurname(entity.getSurname());
        response.setFiscalCode(entity.getFiscalCode());
        response.setUsername(entity.getUsername());
        response.setPassword(entity.getPassword());
        response.setInstituteId(entity.getInstitute().getId());
        return response;
    }

    @Override
    public GetStudentResponse getUsername(GetUsernameStudentRequest request) throws StudentNotFoundException {
        StudentEnt entity = studentRepository.findStudentByUsernameAndInstitute(request.getInstituteId(), request.getUsername());
        if (entity == null) {
            throw new StudentNotFoundException("studente non trovato");
        }
        GetStudentResponse response = new GetStudentResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSurname(entity.getSurname());
        response.setFiscalCode(entity.getFiscalCode());
        response.setUsername(entity.getUsername());
        response.setPassword(entity.getPassword());
        response.setInstituteId(entity.getInstitute().getId());
        return response;
    }




    @Override
    public PutStudentResponse put(PutStudentRequest request) throws DataNonValidException, StudentNotFoundException, StudentAlreadyExistingException {
        if (request.getId() == null ||
                request.getName() == null ||
                request.getSurname() == null ||
                request.getFiscalCode() == null ||
                request.getPassword() == null ||
                request.getUsername() == null
        ) {
            throw new DataNonValidException("dati mancanti");
        }

        StudentEnt entity = studentRepository.findById(request.getId()).orElseThrow(() -> new StudentNotFoundException());

        List<StudentEnt> list = studentRepository.getAllStudentByInstitute(entity.getInstitute().getId());
        for(StudentEnt student : list) {
            if (student.getUsername().equalsIgnoreCase(request.getUsername()) ||
                    student.getFiscalCode().equalsIgnoreCase(request.getFiscalCode())){
                throw new StudentAlreadyExistingException("username o codice fiscale gia esistente");
            }
        }

        entity.setName(request.getName());
        entity.setSurname(request.getSurname());
        entity.setPassword(request.getPassword());
        entity.setFiscalCode(request.getFiscalCode());
        entity.setUsername(request.getUsername());

        PutStudentResponse response = new PutStudentResponse();
        response.setName(request.getName());
        response.setUsername(request.getUsername());
        response.setSurname(request.getSurname());
        response.setPassword(request.getPassword());
        response.setFiscalCode(request.getFiscalCode());
        response.setId(studentRepository.save(entity).getId());
        return response;
    }

     @Override
    public List<GetStudentResponse> getAll(Integer idInstitute) throws DataNonValidException {
        if (idInstitute < 1 || idInstitute == null) {
            throw new DataNonValidException("id istituto non valido");
        }
        List<StudentEnt> students = studentRepository.getAllStudentByInstitute(idInstitute);
        List<GetStudentResponse> response = new ArrayList<>();
        for (StudentEnt student : students){
            GetStudentResponse getAll = new GetStudentResponse();
            getAll.setId(student.getId());
            getAll.setName(student.getName());
            getAll.setUsername(student.getUsername());
            getAll.setSurname(student.getSurname());
            getAll.setPassword(student.getPassword());
            getAll.setFiscalCode(student.getFiscalCode());
            getAll.setInstituteId(student.getInstitute().getId());
            response.add(getAll);
        }
        return response;
    }


    public void delete(Integer request) throws DataNonValidException, StudentNotFoundException {
        if (request == null || request < 1) {
            throw new DataNonValidException("dati mancanti");
        }
        studentRepository.findById(request).orElseThrow(()->new StudentNotFoundException("studente non trovato"));

        studentRepository.deleteById(request);

    }


}
