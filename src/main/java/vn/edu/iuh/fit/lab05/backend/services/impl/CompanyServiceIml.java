package vn.edu.iuh.fit.lab05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Company;
import vn.edu.iuh.fit.lab05.backend.repositories.CompanyRepository;
import vn.edu.iuh.fit.lab05.backend.services.CompanyService;

@Service
public class CompanyServiceIml implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company add(Company company) {
        return companyRepository.save(company);
    }
}
