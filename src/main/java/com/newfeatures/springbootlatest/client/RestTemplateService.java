package com.newfeatures.springbootlatest.client;

import com.newfeatures.springbootlatest.dto.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestTemplateService {

    private static final String user_url = "https://api.github.com/users/amila";

    private final RestTemplate restTemplate;
    private final FeignClientConsumer feignClientConsumer;


    public Users getForEntity() {
        log.info(">> Calling External Api");
        ResponseEntity<Users> userEntity = null;
        try {
            userEntity = restTemplate.getForEntity(user_url, Users.class);
        } catch (Exception exception) {
            log.info("<< Exception occurried while calling external api ", exception.getMessage());
        }

        log.info("<< Response from  External Api");
        System.out.println(userEntity);
        return userEntity.getBody();
    }


    public Users getByFeignClient() {
        log.info(">>Calling external api using the feign client");

        Users users = feignClientConsumer.getUsers();
        System.out.println(users);
        return users;
    }
}
