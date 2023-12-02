package vn.edu.iuh.fit.lab05.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab05.backend.models.Company;

@Service
public interface CompanyService {
    public Company add(Company company);
}
