package com.clan.instaclass.feign.classService;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("CLASS-SERVICE")
public interface ClassClient {
}
