package com.innoventes.test.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.innoventes.test.app.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Task 4 - API Creation for fetching company according to companyCode.
    @Query(value = "Select * FROM company where company_code =: companyCode", nativeQuery = true)
    Optional<Company> findByCompanyCode(String companyCode);
}