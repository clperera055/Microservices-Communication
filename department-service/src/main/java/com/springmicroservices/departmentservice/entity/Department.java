package com.springmicroservices.departmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "department")
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String departmentName;
    private String departmentDescription;
    private String departmentCode;
}
