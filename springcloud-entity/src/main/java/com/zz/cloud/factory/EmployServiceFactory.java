package com.zz.cloud.factory;

import com.zz.cloud.entity.Employee;
import com.zz.cloud.service.EmployService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class EmployServiceFactory implements FallbackFactory<EmployService> {
    @Override
    public EmployService create(Throwable throwable) {
        return new EmployService() {
            @Override
            public Employee getEmployee() {
                return null;
            }

            @Override
            public Employee getEmployeeCircuit(String signal) {
                return null;
            }
        };
    }
}
