package com.iphayao.service.organization;

import com.iphayao.service.department.DepartmentClient;
import com.iphayao.service.employee.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private DepartmentClient departmentClient;

    @Autowired
    private EmployeeClient employeeClient;

    public List<Organization> findAllOrganization() {
        return organizationRepository.findAll();
    }

    public Organization findOrganizationById(String id) {
        Optional<Organization> organization = organizationRepository.findById(id);
        organization.ifPresent(o -> {
            o.setEmployees(employeeClient.findEmployeeByOrganizationId(o.getId()));
            o.setDepartments(departmentClient.findDepartmentByOrganizationId(o.getId()));
        });

        return organization.orElse(null);
    }

    public Organization addNewOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Organization updateOrganization(String id, Organization organization) {
        organizationRepository.findById(id).ifPresent(o -> organization.setId(o.getId()));
        return organizationRepository.save(organization);
    }

    public void deleteOrganization(String id) {
        organizationRepository.deleteById(id);
    }

}
