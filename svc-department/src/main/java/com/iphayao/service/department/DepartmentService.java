package com.iphayao.service.department;

import com.iphayao.service.employee.Employee;
import com.iphayao.service.employee.EmployeeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    public Department findDepartmentById(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department addNewDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String departmentId, Department department) {
        departmentRepository.findById(departmentId).ifPresent(d -> department.setId(d.getId()));
        return departmentRepository.save(department);
    }

    public void deleteDepartment(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public List<Department> findDepartmentByOrganizationId(String organizationId) {
        return departmentRepository.findByOrganizationId(organizationId);
    }

    public List<Department> findDepartmentByOrganizIdWithEmployee(String departmentId) {
        List<Department> departments = departmentRepository.findByOrganizationId(departmentId);
        departments.forEach(department -> {
            List<Employee> employees = employeeClient.findEmployeeByDepartment(department.getId());
            department.setEmployees(employees);
        });

        return departments;
    }
}
