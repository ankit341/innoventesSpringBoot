package com.innoventes.test.app.service;

import java.util.List;

import com.innoventes.test.app.entity.Company;
import com.innoventes.test.app.exception.ValidationException;
import org.springframework.stereotype.Service;

public interface CompanyService {

	List<Company> getAllCompanies();

	Company getCompanyById(Long Id);

	Company addCompany(Company company) throws ValidationException;

	Company updateCompany(Long id, Company company) throws ValidationException;
	
	void deleteCompany(Long id);

	Company getCompanyByCode(String companyCode);
}