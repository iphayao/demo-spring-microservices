package com.iphayao.service.organization;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Organization {
    @Id
    private Long id;
    private String name;
    private String address;
    private List<String> departments;
    private List<String> employees;
}
