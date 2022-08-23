package com.clan.instaclass.feign.instituteService;

import com.clan.instaclass.feign.instituteService.models.institute.GetInstituteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("INSTITUTE-SERVICE")
public interface InstituteClient {
    @GetMapping(
            path = "institute/v1/institutes/{instituteId}"
    )
    GetInstituteResponse getInstitute(@PathVariable("instituteId") Integer instituteId);
}
