package com.innoventes.test.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innoventes.test.app.entity.Company;
import com.innoventes.test.app.error.ApplicationErrorCodes;
import com.innoventes.test.app.exception.ResourceNotFoundException;
import com.innoventes.test.app.exception.ValidationException;
import com.innoventes.test.app.repository.CompanyRepository;
import com.innoventes.test.app.service.CompanyService;
import com.innoventes.test.app.util.ServiceHelper;
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ServiceHelper serviceHelper;

	@Override
	public List<Company> getAllCompanies() {
		ArrayList<Company> companyList = new ArrayList<Company>();
		companyRepository.findAll().forEach(companyList::add);
		return companyList;
	}

	@Override
	public Company getCompanyById(Long id) {
		Optional<Company> company = companyRepository.findById(id);
		if (company.isPresent()) {
			return company.get();
		}
		throw new ResourceNotFoundException(String.format(serviceHelper.getLocalizedMessage(
				ApplicationErrorCodes.COMPANY_NOT_FOUND), id),ApplicationErrorCodes.COMPANY_NOT_FOUND);
	}

	@Override
	public Company addCompany(Company company) throws ValidationException {
		return companyRepository.save(company);
	}

	@Override
	public Company updateCompany(Long id, Company company) throws ValidationException {
		Company existingCompanyRecord = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format(serviceHelper.getLocalizedMessage(ApplicationErrorCodes.COMPANY_NOT_FOUND), id),
						ApplicationErrorCodes.COMPANY_NOT_FOUND));
		company.setId(existingCompanyRecord.getId());
		return companyRepository.save(company);
	}

	@Override
	public void deleteCompany(Long id) {
		Company existingCompanyRecord = companyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(
						String.format(serviceHelper.getLocalizedMessage(ApplicationErrorCodes.COMPANY_NOT_FOUND), id),
						ApplicationErrorCodes.COMPANY_NOT_FOUND));
		companyRepository.deleteById(existingCompanyRecord.getId());
	}

	@Override
	public Company getCompanyByCode(String companyCode) {
		Optional<Company> company = companyRepository.findByCompanyCode(companyCode);
		if (company.isPresent()) {
			return company.get();
		}
		throw new ResourceNotFoundException(String.format(serviceHelper.getLocalizedMessage(
				ApplicationErrorCodes.COMPANY_NOT_FOUND), companyCode),ApplicationErrorCodes.COMPANY_NOT_FOUND);
	}
}
