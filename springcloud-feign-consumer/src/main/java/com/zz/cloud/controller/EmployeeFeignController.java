package com.zz.cloud.controller;

import com.zz.cloud.entity.Employee;
import com.zz.cloud.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeFeignController {

    //装配的是feign远程调用的方法
    @Autowired
    private EmployService employService;


    @GetMapping("get/by/feign")
    public Employee getEmployeeByFeign(){
        return employService.getEmployee();
    }

    @GetMapping("get/by/feign/circuit")
    public Employee getEmployeeByFeignCircuit(@RequestParam("signal") String signal){
        return employService.getEmployeeCircuit(signal);
    }
}
