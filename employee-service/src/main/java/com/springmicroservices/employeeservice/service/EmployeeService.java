package com.springmicroservices.employeeservice.service;

import com.springmicroservices.employeeservice.dto.ApiResponseDTO;
import com.springmicroservices.employeeservice.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

    ApiResponseDTO getEmployeeById(Long id);
}
