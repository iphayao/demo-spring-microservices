package com.iphayao.service.department;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Department {
    private Long id;
    private String name;
    private Long organizationId;
    private List<String> employees;
}
