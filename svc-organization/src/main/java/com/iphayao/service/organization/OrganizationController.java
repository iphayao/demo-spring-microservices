package com.iphayao.service.organization;

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
    public Organization findOrganizationById(@PathVariable Long id) {
        return organizationService.findOrganizationById(id);
    }

    @PostMapping
    public Organization addOrganization(@RequestBody Organization organization) {
        return organizationService.addNewOrganization(organization);
    }

    @GetMapping("/{id}/with-employees")
    public Organization findOrganizationByIdWithEmployees(@PathVariable Long id) {
        return organizationService.findOrganizationById(id);
    }

    @GetMapping("/{id}/with-departments-and-employees")
    public Organization findOrganizationByIdWithDepartmentsAndEmployees(@PathVariable Long id) {
        return organizationService.findOrganizationById(id);
    }

}
