package com.iphayao.service.department;

import com.iphayao.service.employee.Employee;
import com.iphayao.service.employee.EmployeeClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeClient employeeClient;

    public List<Department> findAllDepartment() {
        return departmentRepository.findAll();
    }

    @HystrixCommand(fallbackMethod = "findDepartmentByIdRecovery")
    public Department findDepartmentById(String id) {
        Optional<Department> department = departmentRepository.findById(id);
        department.ifPresent(d -> {
            List<Employee> employees = employeeClient.findEmployeeByDepartmentId(d.getId());
            d.setEmployees(employees);
        });

        return department.orElse(null);
    }

    public Department findDepartmentByIdRecovery(String id) {
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

}
