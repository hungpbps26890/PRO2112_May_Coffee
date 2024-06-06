package com.poly.coffee.service;

import com.poly.coffee.dto.request.BankRequest;
import com.poly.coffee.dto.response.BankResponse;

import java.util.List;

public interface BankService {
      List<BankResponse> getAll();
      BankResponse getById(Integer id);
      BankResponse create(BankRequest request);
      BankResponse update(Integer id, BankRequest request);
      void delete(Integer id);
}
