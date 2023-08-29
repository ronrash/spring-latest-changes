package com.newfeatures.springbootlatest.service;

import java.util.ArrayList;
import java.util.List;

import com.newfeatures.springbootlatest.dto.Customer;
import com.newfeatures.springbootlatest.exception.CustomerNotFoundException;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    // http://localhost:8080/actuator/metrics if u go to this we can see the metrics of our application
    // http://localhost:8080/actuator/metrics/getCustomerById - this will give info about that particular api

    private List<Customer> customerList = new ArrayList<>();

    private final ObservationRegistry observationRegistry;

    public Customer addCustomer(Customer customer) {
        customerList.add(customer);
        // this will help us to publish the metrics to the micrometer or any other 3rd party
        // first param is the metric name

        // return customer
        return Observation.createNotStarted("addCustomer", observationRegistry).observe(() -> customer);
    }

    public List<Customer> getCustomerList() {
        //  return customerList;
        return Observation.createNotStarted("getCustomerList", observationRegistry).observe(() -> customerList);
    }

    public Customer getCustomerById(int id) {
//        return customerList.stream().filter(customer -> customer.id() == id).findAny()
//                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %d is not presend", id)));
        return Observation.createNotStarted("getCustomerById", observationRegistry).observe(() -> customerList.stream().filter(customer -> customer.id() == id).findAny()
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %d is not presend", id))));
    }

}
