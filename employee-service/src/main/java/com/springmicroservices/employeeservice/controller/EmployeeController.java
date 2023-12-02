package com.springmicroservices.employeeservice.controller;

import com.springmicroservices.employeeservice.dto.ApiResponseDTO;
import com.springmicroservices.employeeservice.dto.EmployeeDTO;
import com.springmicroservices.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employee")

public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDTO> saveDepartment(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO saveEmployee = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDTO> getDepartmentById(@PathVariable Long id){
        ApiResponseDTO apiResponseDTO = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
