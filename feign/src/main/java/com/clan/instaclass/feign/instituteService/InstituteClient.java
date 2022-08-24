package com.clan.instaclass.feign.instituteService;

import com.clan.instaclass.feign.instituteService.models.institute.GetInstituteResponse;
import com.clan.instaclass.feign.instituteService.models.student.GetStudentResponse;
import com.clan.instaclass.feign.instituteService.models.teacher.GetTeacherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("INSTITUTE-SERVICE")
public interface InstituteClient {
    @GetMapping(
            path = "institute/v1/institutes/{instituteId}"
    )
    GetInstituteResponse getInstitute(@PathVariable("instituteId") Integer instituteId);

    @GetMapping(
            path = "institute/v1/students/{idStudent}"
    )
    GetStudentResponse getStudent(@PathVariable("idStudent") Integer studentId);

    @GetMapping(
            path = "institute/v1/teachers/{idTeacher}"
    )
     GetTeacherResponse getTeacher(@PathVariable("idTeacher") Integer idTeacher);
}
