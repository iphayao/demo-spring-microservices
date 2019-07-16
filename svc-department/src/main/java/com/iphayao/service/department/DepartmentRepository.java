package com.iphayao.service.department;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DepartmentRepository extends MongoRepository<Department, String> {
    List<Department> findByOrganizationId(String organizationId);
}
