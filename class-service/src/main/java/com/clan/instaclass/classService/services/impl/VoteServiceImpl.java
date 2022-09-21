package com.clan.instaclass.classService.services.impl;

import com.clan.instaclass.classService.entities.ClassEnt;
import com.clan.instaclass.classService.entities.VoteEnt;
import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.vote.VoteNotExistException;
import com.clan.instaclass.classService.exceptions.vote.VoteNotValidException;
import com.clan.instaclass.classService.models.vote.*;
import com.clan.instaclass.classService.repositories.ClassRepository;
import com.clan.instaclass.classService.repositories.VoteRepository;
import com.clan.instaclass.classService.services.VoteService;

import com.clan.instaclass.classService.utility.JWTUtility;
import com.clan.instaclass.feign.instituteService.InstituteClient;
import com.clan.instaclass.feign.instituteService.models.student.GetStudentResponse;
import com.clan.instaclass.feign.instituteService.models.subject.GetSubjectResponse;
import com.clan.instaclass.feign.instituteService.models.teacher.GetTeacherResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class VoteServiceImpl implements VoteService {
    private VoteRepository voteRepository;
    private ClassRepository classRepository;
    private JWTUtility jwtUtility;
    private InstituteClient instituteClient;
    @Override
    public CreateVoteResponse create(CreateVoteRequest request) throws VoteNotValidException, ClassNotExistException {
        if (request.getVote() > 100 ||
            request.getClassEntId() == null ||
            request.getDate() == null ||
            request.getTeacherId() == null ||
            request.getStudenId() == null ||
            request.getSubjectId() == null
        ) {
            throw new VoteNotValidException("dati del voto non validi");
        }
        ClassEnt classEnt = classRepository.findById(request.getClassEntId()).orElseThrow(() -> new ClassNotExistException("classe non trovata"));
            VoteEnt entity = new VoteEnt();
            entity.setVote(request.getVote());
            entity.setDate(request.getDate());
            entity.setClassEnt(classEnt);
            entity.setTeacher(request.getTeacherId());
            entity.setStudent(request.getStudenId());
            entity.setSubject(request.getSubjectId());
            CreateVoteResponse response = new CreateVoteResponse();
            response.setId(voteRepository.save(entity).getId());
            return response;
    }
    @Override
    public List<GetAllVoteResponse> getAllVoteStudent(Integer idStudent) throws VoteNotValidException {
        if (idStudent == null || idStudent < 1) {
            throw new VoteNotValidException("dati errati");
        }
        List<VoteEnt> entity = voteRepository.getAllVoteByStudent(idStudent);
        List<GetAllVoteResponse> response = new ArrayList<>();
        for (VoteEnt vote : entity){
            GetStudentResponse studentResponse = instituteClient.getStudent(vote.getStudent(), jwtUtility.authentication());
            GetTeacherResponse teacherResponse = instituteClient.getTeacher(vote.getTeacher(), jwtUtility.authentication());
            GetAllVoteResponse getAll = new GetAllVoteResponse();
            getAll.setId(vote.getId());
            getAll.setVote(vote.getVote());
            getAll.setDate(vote.getDate());
            getAll.setNameStudent(studentResponse.getName());
            getAll.setSurnameStudent(studentResponse.getSurname());
            getAll.setFiscalCodeStudent(studentResponse.getFiscalCode());
            getAll.setUsernameStudent(studentResponse.getUsername());
            getAll.setSubjectName(teacherResponse.getName());
            getAll.setTeacherName(teacherResponse.getName());
            getAll.setUsername(teacherResponse.getUsername());
            getAll.setTeacherSurname(teacherResponse.getSurname());
            getAll.setFiscalCode(teacherResponse.getFiscalCode());
            getAll.setClassEnt(vote.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public List<GetAllVoteResponse> getAllVoteClass(Integer idClass) throws VoteNotValidException {
        if (idClass == null || idClass < 1) {
            throw new VoteNotValidException("dati errati");
        }
        List<VoteEnt> entity = voteRepository.getAllVoteByClass(idClass);
        List<GetAllVoteResponse> response = new ArrayList<>();
        for (VoteEnt vote : entity){
            GetStudentResponse studentResponse = instituteClient.getStudent(vote.getStudent(), jwtUtility.authentication());
            GetTeacherResponse teacherResponse = instituteClient.getTeacher(vote.getTeacher(), jwtUtility.authentication());
            GetSubjectResponse subjectResponse = instituteClient.getSubjectById(vote.getSubject(), jwtUtility.authentication());
            GetAllVoteResponse getAll = new GetAllVoteResponse();
            getAll.setId(vote.getId());
            getAll.setVote(vote.getVote());
            getAll.setDate(vote.getDate());
            getAll.setNameStudent(studentResponse.getName());
            getAll.setSurnameStudent(studentResponse.getSurname());
            getAll.setFiscalCode(studentResponse.getFiscalCode());
            getAll.setUsername(studentResponse.getUsername());
            getAll.setSubjectName(subjectResponse.getName());
            getAll.setTeacherName(teacherResponse.getName());
            getAll.setUsername(teacherResponse.getUsername());
            getAll.setTeacherSurname(teacherResponse.getSurname());
            getAll.setFiscalCode(teacherResponse.getFiscalCode());
            getAll.setClassEnt(vote.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    @Override
    public List<GetAllVoteResponse> getAllVoteTeacher(Integer idTeacher) throws VoteNotValidException {
        if (idTeacher == null || idTeacher < 1) {
            throw new VoteNotValidException("dati errati");
        }
        List<VoteEnt> entity = voteRepository.getAllVoteByTeacher(idTeacher);
        List<GetAllVoteResponse> response = new ArrayList<>();
        for (VoteEnt vote : entity){
            GetStudentResponse studentResponse = instituteClient.getStudent(vote.getStudent(), jwtUtility.authentication());
            GetSubjectResponse subjectResponse = instituteClient.getSubjectById(vote.getSubject(), jwtUtility.authentication());
            GetTeacherResponse teacherResponse = instituteClient.getTeacher(vote.getTeacher(), jwtUtility.authentication());
            GetAllVoteResponse getAll = new GetAllVoteResponse();
            getAll.setId(vote.getId());
            getAll.setVote(vote.getVote());
            getAll.setDate(vote.getDate());
            getAll.setNameStudent(studentResponse.getName());
            getAll.setSurnameStudent(studentResponse.getSurname());
            getAll.setFiscalCode(studentResponse.getFiscalCode());
            getAll.setUsername(studentResponse.getUsername());
            getAll.setSubjectName(subjectResponse.getName());
            getAll.setTeacherName(teacherResponse.getName());
            getAll.setUsername(teacherResponse.getUsername());
            getAll.setTeacherSurname(teacherResponse.getSurname());
            getAll.setFiscalCode(teacherResponse.getFiscalCode());
            getAll.setClassEnt(vote.getClassEnt().getId());
            response.add(getAll);
        }
        return response;
    }

    public PutVoteResponse update(PutVoteRequest request) throws VoteNotValidException, VoteNotExistException {
        if (request.getDate() == null || request.getId() == null || request.getVote() > 100 || request.getVote() == null) {
            throw new VoteNotValidException("dati mancanti");
        }
        VoteEnt entity = voteRepository.findById(request.getId()).orElseThrow(() -> new VoteNotExistException("istituto non trovato"));
        if (entity.getTeacher() != request.getDocenteId()) {
            throw new VoteNotValidException("docente non valido ad aggiornare");
        }
        entity.setId(request.getId());
        entity.setVote(request.getVote());
        entity.setDate(request.getDate());
        PutVoteResponse response = new PutVoteResponse();
        response.setDate(request.getDate());
        response.setVote(request.getVote());
        response.setId(voteRepository.save(entity).getId());
        return response;
    }

    @Override
    public GetVoteResponse getVote(Integer idVote) throws VoteNotValidException, VoteNotExistException {
        if (idVote == null || idVote < 1) {
            throw new VoteNotValidException("dati errati");
        }
        VoteEnt entity = voteRepository.findById(idVote).orElseThrow(() -> new VoteNotExistException("voto non trovato"));
        GetStudentResponse studentResponse = instituteClient.getStudent(entity.getStudent(), jwtUtility.authentication());
        GetTeacherResponse teacherResponse = instituteClient.getTeacher(entity.getTeacher(), jwtUtility.authentication());
        GetVoteResponse response = new GetVoteResponse();
        response.setId(entity.getId());
        response.setVote(entity.getVote());
        response.setNameStudent(studentResponse.getName());
        response.setSurnameStudent(studentResponse.getSurname());
        response.setFiscalCodeStudent(studentResponse.getFiscalCode());
        response.setSubject(entity.getSubject());
        response.setUsername(teacherResponse.getUsername());
        response.setTeacherName(teacherResponse.getName());
        response.setTeacherSurname(teacherResponse.getSurname());
        response.setFiscalCode(teacherResponse.getFiscalCode());
        response.setDate(entity.getDate());
        response.setClassEnt(entity.getClassEnt().getId());
        return response;
    }


    public void delete(Integer request) throws VoteNotValidException, VoteNotExistException {
        if (request == null || request < 1) {
            throw new VoteNotValidException("dati errati");
        }
        VoteEnt entity = voteRepository.findById(request).orElseThrow(()->new VoteNotExistException("voto non trovato"));

        voteRepository.deleteById(request);

    }

}
