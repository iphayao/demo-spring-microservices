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
    public Employee findEmployee(@PathVariable String id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addNewEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee editEmployee(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id, employee);
    }

    @DeleteMapping
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findEmployeeByDepartmentId(@PathVariable String departmentId) {
        return employeeService.findEmployeeByDepartmentId(departmentId);
    }

    @GetMapping("/organization/{organizationId}")
    public List<Employee> findEmployeeByOrganizationId(@PathVariable String organizationId) {
        return employeeService.findEmployeeByOrganizationId(organizationId);
    }
}
