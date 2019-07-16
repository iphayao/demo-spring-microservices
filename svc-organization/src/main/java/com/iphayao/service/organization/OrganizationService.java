package com.iphayao.service.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> findAllOrganization() {
        return organizationRepository.findAll();
    }

    public Organization findOrganizationById(Long id) {
        return organizationRepository.findById(id).orElse(null);
    }

    public Organization addNewOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }
}
