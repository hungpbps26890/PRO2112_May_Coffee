package com.poly.coffee.service;

import com.poly.coffee.dto.request.VoucherRequest;
import com.poly.coffee.dto.response.VoucherResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface VoucherService {
      List<VoucherResponse> getAll();
      List<VoucherResponse> getValidByCurrentDate();
      VoucherResponse getById(Long id);
      VoucherResponse create(VoucherRequest request);
      VoucherResponse update(Long id, VoucherRequest request);
      void delete(Long id);
}
