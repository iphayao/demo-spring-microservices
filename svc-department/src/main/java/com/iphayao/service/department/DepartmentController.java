package com.iphayao.service.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> findAllDepartment() {
        return departmentService.findAllDepartment();
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Long id) {
        return departmentService.findDepartmentById(id);
    }

    @PostMapping
    public Department addNewDepartment(@RequestBody Department department) {
        return departmentService.addNewDepartment(department);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Department> findDepartmentByOrganizationId(@PathVariable Long organizationId) {
        return departmentService.findDepartmentOrganizationId(organizationId);
    }
}
