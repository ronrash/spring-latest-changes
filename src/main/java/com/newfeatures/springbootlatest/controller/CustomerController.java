package com.newfeatures.springbootlatest.controller;

import com.newfeatures.springbootlatest.dto.Customer;
import com.newfeatures.springbootlatest.dto.Users;
import com.newfeatures.springbootlatest.client.RestTemplateService;
import com.newfeatures.springbootlatest.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final RestTemplateService restTemplateService;


    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer addCustomer(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    // Using the RestTemplate
    @GetMapping("/users")
    public ResponseEntity<Users> getUserViaRestTemplate() {
        return ResponseEntity.ok(restTemplateService.getForEntity());

    }

    @GetMapping("/users/feign")
    public ResponseEntity<Users> getUsersViaFeignClient() {
        return ResponseEntity.ok(restTemplateService.getByFeignClient());

    }
}
