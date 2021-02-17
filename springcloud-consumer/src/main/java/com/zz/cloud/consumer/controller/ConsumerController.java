package com.zz.cloud.consumer.controller;


import com.zz.cloud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("get/employ/remote")
    public Employee getFromRemote(){

        String url = "http://localhost:1000/get/employ";

        return restTemplate.getForObject(url, Employee.class);
    }

    @GetMapping("get/employ/remote/ribbon")
    public Employee getFromRemoteByRibbon(){

        String url = "http://provider/get/employ";

        return restTemplate.getForObject(url, Employee.class);
    }
}
