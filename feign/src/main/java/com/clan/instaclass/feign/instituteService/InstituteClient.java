package com.clan.instaclass.feign.instituteService;

import com.clan.instaclass.feign.instituteService.models.institute.GetInstituteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "institute",
        url = "http://INSTITUTE-SERVICE/institute"
)
public interface InstituteClient {
    @GetMapping(
            path = "/v1/institutes/{instituteId}"
    )
    GetInstituteResponse getInstitute(@PathVariable("instituteId") Integer instituteId);
}
