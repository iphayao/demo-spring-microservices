package com.iphayao.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> findAllEmployee() {
        return employeeService.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartmentId(@PathVariable Long departmentId) {
        return employeeService.findEmployeeByDepartmentId(departmentId);
    }

    public List<Employee> findEmployeeByOrganizationId(@PathVariable Long organizationId) {
        return employeeService.findEmployeeByOrganizationId(organizationId);
    }

}
