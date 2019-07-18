package com.iphayao.service.department;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("department-service")
public interface DepartmentClient {

    @GetMapping("/departments/organization/{organizationId}")
    List<Department> findDepartmentByOrganizationId(@PathVariable String organizationId);

}
