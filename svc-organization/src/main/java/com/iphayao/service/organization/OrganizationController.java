package com.iphayao.service.organization;

import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public List<Organization> findAllOrganization() {
        return organizationService.findAllOrganization();
    }

    @GetMapping("/{id}")
    public Organization findOrganizationById(@PathVariable String id) {
        return organizationService.findOrganizationById(id);
    }

    @PostMapping
    public Organization addOrganization(@RequestBody Organization organization) {
        return organizationService.addNewOrganization(organization);
    }

    @PutMapping("/{id}")
    public Organization putOrganization(@PathVariable String id, @RequestBody Organization organization) {
        return organizationService.updateOrganization(id, organization);
    }

    @DeleteMapping("/{id}")
    public void deleteOrganization(@PathVariable String id) {
        organizationService.deleteOrganization(id);
    }

    @GetMapping("/{id}/with-employees")
    public Organization findOrganizationByIdWithEmployees(@PathVariable String id) {
        return organizationService.findOrganizationByIdWithEmployees(id);
    }

    @GetMapping("/{id}/with-departments")
    public Organization findOrganizationByIdWithDepartment(@PathVariable String id) {
        return organizationService.findOrganizationByIdWithDepartments(id);
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findOrganizationByIdWithDepartmentsAndEmployees(@PathVariable String id) {
        return organizationService.findOrganizationByIdWithDepartmentsAndEmployees(id);
    }

}
