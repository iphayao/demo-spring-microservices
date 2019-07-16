package com.iphayao.service.employee;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {
    @Id
    private String id;
    private String name;
    private int age;
    private String position;
    private String organizationId;
    private String departmentId;
}
