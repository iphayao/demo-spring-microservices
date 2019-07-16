package com.iphayao.service.organization;

import com.iphayao.service.department.Department;
import com.iphayao.service.department.DepartmentClient;
import com.iphayao.service.employee.EmployeeClient;
import org.aspectj.weaver.ast.Or;
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
        return organizationRepository.findById(id).orElse(null);
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

    public Organization findOrganizationByIdWithEmployees(String id) {
        Optional<Organization> org = organizationRepository.findById(id);
        org.ifPresent(o -> o.setEmployees(employeeClient.findEmployeeByOrganization(o.getId())));
        return org.orElse(null);
    }

    public Organization findOrganizationByIdWithDepartments(String id) {
        Optional<Organization> org = organizationRepository.findById(id);
        org.ifPresent(o -> o.setDepartments(departmentClient.findDepartmentByOrganizationIdWithEmployee(id)));
        return org.orElse(null);
    }

    public Organization findOrganizationByIdWithDepartmentsAndEmployees(String id) {
        Optional<Organization> org = organizationRepository.findById(id);
        org.ifPresent(o -> {
            o.setDepartments(departmentClient.findDepartmentByOrganizationId(o.getId()));
            o.setEmployees(employeeClient.findEmployeeByOrganization(o.getId()));
        });
        return org.orElse(null);
    }

}
