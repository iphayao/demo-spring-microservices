package com.iphayao.service.employee;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, Long> {
    List<Employee> findByOrganizationId(Long organizationId);
    List<Employee> findByDepartmentId(Long departmentId);
}
