package com.employeeservice.dto;

import com.departmentservice.entity.Department;
import com.employeeservice.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Employee employee;
    private Department department;
}
