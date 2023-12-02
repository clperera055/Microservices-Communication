package com.springmicroservices.employeeservice.service.impl;

import com.springmicroservices.employeeservice.dto.ApiResponseDTO;
import com.springmicroservices.employeeservice.dto.DepartmentDTO;
import com.springmicroservices.employeeservice.dto.EmployeeDTO;
import com.springmicroservices.employeeservice.entity.Employee;
import com.springmicroservices.employeeservice.repo.EmployeeRepo;
import com.springmicroservices.employeeservice.service.APIClient;
import com.springmicroservices.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getId(),
                employeeDTO.getFirstName(),
                employeeDTO.getSecondName(),
                employeeDTO.getEmail(),
                employeeDTO.getDepartmentCode()
        );
        Employee saveEmployee = employeeRepo.save(employee);
        EmployeeDTO saveEmployeeDto = new EmployeeDTO(
                saveEmployee.getId(),
                saveEmployee.getFirstName(),
                saveEmployee.getSecondName(),
                saveEmployee.getEmail(),
                saveEmployee.getDepartmentCode()
        );
        return saveEmployeeDto;
    }

    @Override
    public ApiResponseDTO getEmployeeById(Long id) {

        Employee employee = employeeRepo.findById(id).get();

        DepartmentDTO departmentDTO = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getSecondName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDTO(employeeDTO);
        apiResponseDTO.setDepartmentDTO(departmentDTO);

        return apiResponseDTO;
    }
}
