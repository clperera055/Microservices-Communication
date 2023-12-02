package com.springmicroservices.departmentservice.service;

import com.springmicroservices.departmentservice.dto.DepartmentDTO;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentByCode(String code);
}
