package com.iphayao.service.department;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.iphayao.service.employee.Employee;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {
    private String id;
    private String name;
    private String organizationId;
    private List<Employee> employees;
}
