package com.clan.instaclass.institute;

import com.clan.instaclass.models.institute.CreateInstituteRequestDTO;
import com.clan.instaclass.models.institute.CreateInstituteResponseDTO;
import com.clan.instaclass.models.institute.GetInstituteResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "INSTITUTE-SERVICE", url = "http://localhost:9191/institute/v1/institutes")
public interface FeignInstitute {

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreateInstituteResponseDTO create(@RequestBody CreateInstituteRequestDTO request);

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public GetInstituteResponseDTO get(@PathVariable("id") Integer instituteId);
}
