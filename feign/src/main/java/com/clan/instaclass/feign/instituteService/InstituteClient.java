package com.clan.instaclass.feign.instituteService;

import com.clan.instaclass.feign.instituteService.models.institute.GetInstituteResponse;
import com.clan.instaclass.feign.instituteService.models.student.GetStudentResponse;
import com.clan.instaclass.feign.instituteService.models.subject.GetSubjectResponse;
import com.clan.instaclass.feign.instituteService.models.teacher.GetTeacherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient("INSTITUTE-SERVICE")
public interface InstituteClient {
    @GetMapping(
            path = "institute/v1/institutes/{instituteId}"
    )
    GetInstituteResponse getInstitute(@PathVariable("instituteId") Integer instituteId, @RequestHeader(name = "Authorization")String token);

    @GetMapping(
            path = "institute/v1/students/{idStudent}"
    )
    GetStudentResponse getStudent(@PathVariable("idStudent") Integer studentId);

    @GetMapping(
            path = "institute/v1/teachers/{idTeacher}"
    )
     GetTeacherResponse getTeacher(@PathVariable("idTeacher") Integer idTeacher);

    @GetMapping(
            path = "institute/v1/subjects/{idSubject}"
    )
    GetSubjectResponse getSubjectById(@PathVariable("idSubject") Integer subjectId);
}
