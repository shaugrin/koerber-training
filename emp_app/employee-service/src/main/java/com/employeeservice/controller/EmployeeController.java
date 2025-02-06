package com.employeeservice.controller;


import com.departmentservice.entity.Department;

import com.employeeservice.dto.EmployeeDTO;
import com.employeeservice.entity.Employee;
import com.employeeservice.service.EmployeeService;
import com.employeeservice.serviceproxy.DepartmentServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @Autowired
    private DepartmentServiceProxy departmentServiceProxy;

    // http://localhost:8100/employees
    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = service.getAllEmployees();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for (Employee employee : employees) {
            Department departmentDTO = departmentServiceProxy.getDepartmentById(employee.getDepartmentId());
            EmployeeDTO employeeDTO = new EmployeeDTO(employee, departmentDTO);
            employeeDTOs.add(employeeDTO);
        }

        return employeeDTOs;
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        Employee employee = service.getEmployeeById(id);
        Department departmentDTO = departmentServiceProxy.getDepartmentById(employee.getDepartmentId());
        return new EmployeeDTO(employee, departmentDTO);
    }
}
