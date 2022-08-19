package com.clan.instaclass.institute;

import com.clan.instaclass.models.institute.CreateInstituteRequestDTO;
import com.clan.instaclass.models.institute.CreateInstituteResponseDTO;
import com.clan.instaclass.models.institute.GetInstituteResponseDTO;
import com.clan.instaclass.models.student.GetStudentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "INSTITUTE-SERVICE", url = "http://localhost:9191/institute/v1/students")
public interface FeignStudent {

    @RequestMapping(
            path = "/getAll/{idInstitute}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<GetStudentResponseDTO>> getAll(@PathVariable("idInstitute") Integer idInstitute);

}
