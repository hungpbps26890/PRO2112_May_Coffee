package com.poly.coffee.service;


import com.poly.coffee.dto.request.PaymentMethodBankRequest;
import com.poly.coffee.dto.response.PaymentMethodBankResponse;
import com.poly.coffee.entity.PaymentMethodBank;

import java.util.List;

public interface PaymentMethodBankService {
      List<PaymentMethodBank> getAll();
      PaymentMethodBankResponse getById(Long id);
      PaymentMethodBankResponse create(PaymentMethodBankRequest request);
}
