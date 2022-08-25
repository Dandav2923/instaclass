package com.clan.instaclass.instituteService.services.impls;

import com.clan.instaclass.feign.instituteService.models.teacher.*;
import com.clan.instaclass.instituteService.entities.SubjectEnt;
import com.clan.instaclass.instituteService.entities.TeacherEnt;
import com.clan.instaclass.instituteService.exceptions.general.DataNonValidException;
import com.clan.instaclass.instituteService.exceptions.subject.SubjectNotFoundException;
import com.clan.instaclass.instituteService.exceptions.teacher.TeacherAlreadyExistingException;
import com.clan.instaclass.instituteService.exceptions.teacher.TeacherNotFoundException;
import com.clan.instaclass.feign.instituteService.models.subject.GetSubjectResponse;
import com.clan.instaclass.instituteService.models.teacher.*;
import com.clan.instaclass.instituteService.repositories.InstituteRepository;
import com.clan.instaclass.instituteService.repositories.SubjectRepository;
import com.clan.instaclass.instituteService.repositories.TeacherRepository;
import com.clan.instaclass.instituteService.services.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class TeacherServiceImpl  implements TeacherService{

    private TeacherRepository teacherRepository;
    private InstituteRepository instituteRepository;

    private SubjectRepository subjectRepository;

    @Override
    public void teacherSubjectConnect(ConnectTeacherSubjectRequest request) throws TeacherNotFoundException, SubjectNotFoundException {
        TeacherEnt teacher = teacherRepository.findById(request.getTeacherId()).orElseThrow(()-> new TeacherNotFoundException("docente non trovato"));
        for (Integer intero : request.getSubjectIdList()) {
            SubjectEnt sub = subjectRepository.findById(intero).orElseThrow(() -> new SubjectNotFoundException("materia non trovata"));
            teacher.getSubjects().add(sub);
        }
        teacherRepository.save(teacher);
    }


    @Override
    public CreateTeacherResponse create(CreateTeacherRequest request) throws DataNonValidException, TeacherAlreadyExistingException{
        if (request.getName() == null ||
                request.getInstituteId() < 1 ||
                request.getFiscalCode() == null ||
                request.getFiscalCode().length() != 16 ||
                request.getSurname() == null ||
                request.getUsername() == null
        ) {
            throw new DataNonValidException("dati mancanti");
        }
        List<TeacherEnt> teachers = teacherRepository.getAllTeacherByInstitute(request.getInstituteId());

        for(TeacherEnt teacher : teachers) {
            if (teacher.getUsername().equalsIgnoreCase(request.getUsername()) || teacher.getFiscalCode().equalsIgnoreCase(request.getFiscalCode()))
            {
                throw new TeacherAlreadyExistingException("insegnante gia esistente");
            }
        }
        TeacherEnt entity = new TeacherEnt();
        entity.setName(request.getName());
        entity.setUsername(request.getUsername());
        entity.setFiscalCode(request.getFiscalCode());
        entity.setSurname(request.getSurname());
        entity.setPassword(request.getPassword());
        entity.setInstitute(instituteRepository.getReferenceById(request.getInstituteId()));
        CreateTeacherResponse response = new CreateTeacherResponse();
        response.setId(teacherRepository.save(entity).getId());
        return response;
    }


    @Override
    public GetTeacherResponse get(Integer teacherId) throws TeacherNotFoundException {
        TeacherEnt entity = teacherRepository.findById(teacherId).orElseThrow(TeacherNotFoundException::new);
        GetTeacherResponse response = new GetTeacherResponse();
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
    public List<GetSubjectResponse> getSubjects(Integer teacherId) throws TeacherNotFoundException {
        TeacherEnt entity = teacherRepository.findById(teacherId).orElseThrow(TeacherNotFoundException::new);
        List<GetSubjectResponse> response = new ArrayList<>();
        for (SubjectEnt subject: entity.getSubjects()) {
            GetSubjectResponse getSubject = new GetSubjectResponse();
            getSubject.setName(subject.getName());
            getSubject.setId(subject.getId());
            getSubject.setInstituteId(subject.getInstitute().getId());
            response.add(getSubject);
        }
        return response;
    }

    @Override
    public GetTeacherResponse getUsername(GetUsernameTeacherRequest request) throws TeacherNotFoundException {
        TeacherEnt entity = teacherRepository.findTeacherByUsernameAndInstitute(request.getIdInstitute(), request.getUsername());
        if (entity == null) {
            throw new TeacherNotFoundException("insegnante non trovato");
        }
        GetTeacherResponse response = new GetTeacherResponse();
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
    public List<GetTeacherResponse> getAll(Integer idInstitute) throws DataNonValidException {
        if (idInstitute < 1 || idInstitute == null) {
            throw new DataNonValidException("id isituto non valido");
        }
        List<TeacherEnt> teachers = teacherRepository.getAllTeacherByInstitute(idInstitute);
        List<GetTeacherResponse> response = new ArrayList<GetTeacherResponse>();
        for (TeacherEnt teacher : teachers){
            GetTeacherResponse getAll = new GetTeacherResponse();
            getAll.setId(teacher.getId());
            getAll.setName(teacher.getName());
            getAll.setUsername(teacher.getUsername());
            getAll.setSurname(teacher.getSurname());
            getAll.setPassword(teacher.getPassword());
            getAll.setFiscalCode(teacher.getFiscalCode());
            getAll.setInstituteId(teacher.getInstitute().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public PutTeacherResponse put(PutTeacherRequest request) throws DataNonValidException, TeacherNotFoundException, TeacherAlreadyExistingException {
        if (request.getId() == null ||
                request.getName() == null ||
                request.getSurname() == null ||
                request.getFiscalCode() == null ||
                request.getPassword() == null ||
                request.getUsername() == null
        ) {
            throw new DataNonValidException("dati mancanti");
        }

        TeacherEnt entity = teacherRepository.findById(request.getId()).orElseThrow(() -> new TeacherNotFoundException());


        List<TeacherEnt> list = teacherRepository.getAllTeacherByInstitute(entity.getInstitute().getId());
        for(TeacherEnt teacher : list) {
            if (teacher.getUsername().equalsIgnoreCase(request.getUsername()) ||
                    teacher.getFiscalCode().equalsIgnoreCase(request.getFiscalCode())){
                throw new TeacherAlreadyExistingException("username o codice fiscale gia esistente");
            }
        }

        entity.setName(request.getName());
        entity.setSurname(request.getSurname());
        entity.setPassword(request.getPassword());
        entity.setFiscalCode(request.getFiscalCode());
        entity.setUsername(request.getUsername());

        PutTeacherResponse response = new PutTeacherResponse();
        response.setName(request.getName());
        response.setUsername(request.getUsername());
        response.setSurname(request.getSurname());
        response.setPassword(request.getPassword());
        response.setFiscalCode(request.getFiscalCode());
        response.setId(teacherRepository.save(entity).getId());
        return response;
    }


    public void delete(Integer request) throws DataNonValidException, TeacherNotFoundException {
        if (request == null || request < 1) {
            throw new DataNonValidException("dati mancanti");
        }
        teacherRepository.findById(request).orElseThrow(()->new TeacherNotFoundException("docente non trovato"));

        teacherRepository.deleteById(request);

    }
    


}
