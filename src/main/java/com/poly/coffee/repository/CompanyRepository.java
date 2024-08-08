package com.poly.coffee.repository;

import com.poly.coffee.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
