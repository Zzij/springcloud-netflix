package com.zz.cloud.provider.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.zz.cloud.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployController {

    @GetMapping("get/employ")
    public Employee getEmployee(){
        Employee employee = new Employee();
        employee.setEmpId(12);
        employee.setEmpName("zzj");
        employee.setEmpSalary(1000.00);
        return employee;
    }

    @GetMapping("get/employ/circuit")
    @HystrixCommand(fallbackMethod = "getEmployeeCircuitBackup")
    public Employee getEmployeeCircuit(@RequestParam("signal") String signal){
        if(signal.equals("zzj")){
            throw new RuntimeException("error");
        }

        if(signal.equals("aaa")){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Employee employee = new Employee();
        employee.setEmpId(12);
        employee.setEmpName(signal);
        employee.setEmpSalary(1000.00);
        return employee;
    }

    public Employee getEmployeeCircuitBackup(String signal){
        Employee employee = new Employee();
        employee.setEmpId(11);
        employee.setEmpName("error");
        employee.setEmpSalary(1000.00);
        return employee;
    }
}
