package com.clan.instaclass.feign.classService;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "class",
        url = "http://CLASS-SERVICE/class"
)

public interface ClassClient {
}
