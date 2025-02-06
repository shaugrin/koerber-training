package com.employeeservice.serviceproxy;

import com.departmentservice.entity.Department;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Service
@FeignClient(name = "department-service")
public interface DepartmentServiceProxy {
    @CircuitBreaker(name = "departmentServiceProxy", fallbackMethod = "fallbackGetDepartmentById")
    @Retry(name = "departmentServiceProxy", fallbackMethod = "fallbackGetDepartmentById")
    @GetMapping("/departments/{id}")
    Department getDepartmentById(@PathVariable("id") Long id);

    default Department fallbackGetDepartmentById(Long id, Throwable throwable) {
        return new Department(id, "Unknown Department", null);
    }
}