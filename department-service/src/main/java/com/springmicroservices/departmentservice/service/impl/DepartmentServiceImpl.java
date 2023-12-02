package com.springmicroservices.departmentservice.service.impl;

import com.springmicroservices.departmentservice.dto.DepartmentDTO;
import com.springmicroservices.departmentservice.entity.Department;
import com.springmicroservices.departmentservice.repo.DepartmentRepo;
import com.springmicroservices.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department(
                departmentDTO.getId(),
                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode()
        );
        Department saveDepartment = (Department) departmentRepo.save(department);
        DepartmentDTO savedDepartmentDTO = new DepartmentDTO(
                saveDepartment.getId(),
                saveDepartment.getDepartmentName(),
                saveDepartment.getDepartmentDescription(),
                saveDepartment.getDepartmentCode()
        );

        return savedDepartmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        Department department = departmentRepo.findByDepartmentCode(code);
        DepartmentDTO departmentDTO = new DepartmentDTO(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
        return departmentDTO;
    }
}
