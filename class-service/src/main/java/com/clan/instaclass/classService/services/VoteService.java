package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.classes.ClassNotExistException;
import com.clan.instaclass.classService.exceptions.vote.VoteNotExistException;
import com.clan.instaclass.classService.exceptions.vote.VoteNotValidException;
import com.clan.instaclass.classService.models.vote.*;

import java.util.List;

public interface VoteService {

    CreateVoteResponse create(CreateVoteRequest request) throws VoteNotValidException, ClassNotExistException;

    List<GetAllVoteResponse> getAllVoteStudent(Integer idStudent) throws VoteNotValidException;

    List<GetAllVoteResponse> getAllVoteClass(Integer idClass) throws VoteNotValidException;

    List<GetAllVoteResponse> getAllVoteTeacher(Integer idTeacher) throws VoteNotValidException;

    PutVoteResponse update(PutVoteRequest request) throws VoteNotValidException, VoteNotExistException;

    GetVoteResponse getVote(Integer idVote) throws VoteNotValidException, VoteNotExistException;

    public void delete(Integer request) throws VoteNotValidException, VoteNotExistException;
}
