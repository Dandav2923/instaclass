package com.clan.instaclass.classService.services;

import com.clan.instaclass.classService.exceptions.classes.ClassExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkNotExistException;
import com.clan.instaclass.classService.exceptions.homework.HomeworkNotValidException;
import com.clan.instaclass.classService.models.homework.*;

import java.util.List;

public interface HomeworkService {
    CreateHomeworkResponse create(CreateHomeworkRequest request) throws HomeworkExistException, HomeworkNotValidException, ClassExistException;
    List<GetHomeworkResponse> findAllHomeworks(Integer id) throws HomeworkNotValidException;
    PutHomeworkResponse updateHomework(PutHomeworkRequest request) throws HomeworkNotValidException, HomeworkNotExistException;
    void deleteHomework(DeleteHomeworkRequest request) throws HomeworkNotValidException, HomeworkNotExistException;
}
