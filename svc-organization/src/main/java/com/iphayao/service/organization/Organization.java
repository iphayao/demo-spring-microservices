package com.iphayao.service.organization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.iphayao.service.department.Department;
import com.iphayao.service.employee.Employee;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Organization {
    @Id
    private String id;
    private String name;
    private String address;
    private List<Department> departments;
    private List<Employee> employees;
}
