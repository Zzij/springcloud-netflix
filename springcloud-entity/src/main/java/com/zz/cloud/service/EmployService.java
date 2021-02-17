package com.zz.cloud.service;

import com.zz.cloud.entity.Employee;
import com.zz.cloud.factory.EmployServiceFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//表示调用的是app.name是provider的服务
//fallbackFactory调用端降级方案，还需在调用端打开配置
@FeignClient(value = "provider", fallbackFactory = EmployServiceFactory.class)
public interface EmployService {

    //远程调用的方法，要求映射地址一致，方法声明一致，都要一致且不能省略
    @GetMapping("get/employ")
    public Employee getEmployee();

    @GetMapping("get/employ/circuit")
    public Employee getEmployeeCircuit(@RequestParam("signal") String signal);
}
