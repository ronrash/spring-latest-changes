package com.newfeatures.springbootlatest.client;

import com.newfeatures.springbootlatest.dto.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="RefernceDataService",url = "https://api.github.com")
public interface FeignClientConsumer {
    @GetMapping("/users/amila")
    Users getUsers();
}
