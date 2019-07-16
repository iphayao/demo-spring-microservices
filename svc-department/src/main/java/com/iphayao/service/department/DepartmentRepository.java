package com.iphayao.service.department;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, Long> {
    List<Department> findByOrganizationId(Long organizationId);
}
