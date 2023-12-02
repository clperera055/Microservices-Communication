package com.springmicroservices.departmentservice.repo;

import com.springmicroservices.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String code);
}
