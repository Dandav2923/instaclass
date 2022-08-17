package com.clan.apiGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/classServiceFallBack")
    public String classServiceFallBackMethod() {
        return "Class Service is taking longer than expected." +
                "Please try again";
    }

    @GetMapping("/instituteServiceFallBack")
    public String instituteServiceFallBackMethod() {
        return "institute Service is taking longer than expected." +
                "Please try again";
    }

    @GetMapping("/superAdminServiceFallBack")
    public String superAdminServiceFallBackMethod() {
        return "SuperAdmin Service is taking longer than expected" +
                "Please try again";
    }
}
