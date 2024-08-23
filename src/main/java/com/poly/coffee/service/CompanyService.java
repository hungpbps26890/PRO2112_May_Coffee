package com.poly.coffee.service;

import com.poly.coffee.dto.request.CompanyRequest;
import com.poly.coffee.dto.response.CompanyResponse;

public interface CompanyService {
    CompanyResponse updateCompany(Long id, CompanyRequest request);
    CompanyResponse getCompanyById(Long id);
}
