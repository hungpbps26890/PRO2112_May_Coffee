package com.poly.coffee.service;

import com.poly.coffee.dto.request.VoucherTypeRequest;
import com.poly.coffee.dto.response.VoucherTypeResponse;

import java.util.List;

public interface VoucherTypeService {
      List<VoucherTypeResponse> getAll();
      VoucherTypeResponse getById(Integer id);
      VoucherTypeResponse create(VoucherTypeRequest request);
      VoucherTypeResponse update(Integer id, VoucherTypeRequest request);
      void delete(Integer id);
}
