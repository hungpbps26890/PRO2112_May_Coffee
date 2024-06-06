package com.poly.coffee.service;


import com.poly.coffee.dto.request.PaymentMethodBankRequest;
import com.poly.coffee.dto.response.PaymentMethodBankResponse;

import java.util.List;

public interface PaymentMethodBankService {
      List<PaymentMethodBankResponse> getAll();
      PaymentMethodBankResponse getById(Long id);
      PaymentMethodBankResponse create(PaymentMethodBankRequest request);
}
