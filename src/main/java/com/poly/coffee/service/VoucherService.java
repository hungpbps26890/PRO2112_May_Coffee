package com.poly.coffee.service;

import com.poly.coffee.dto.request.VoucherRequest;
import com.poly.coffee.dto.response.VoucherResponse;

import java.util.List;

public interface VoucherService {
      List<VoucherResponse> getAll();
      VoucherResponse getById(Long id);
      VoucherResponse create(VoucherRequest request);
      VoucherResponse update(Long id, VoucherRequest request);
      void delete(Long id);
}
