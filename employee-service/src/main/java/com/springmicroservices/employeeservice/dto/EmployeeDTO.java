package com.springmicroservices.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EmployeeDTO {

    private long id;
    private String firstName;
    private String secondName;
    private String email;
    private String departmentCode;
}
