package com.iphayao.service.employee;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findByDepartmentId(String departmentId);
    List<Employee> findByOrganizationId(String organizationId);
}
