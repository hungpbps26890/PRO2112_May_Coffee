package com.poly.coffee.service;


import com.poly.coffee.dto.request.PaymentMethodRequest;
import com.poly.coffee.dto.response.PaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {
      List<PaymentMethodResponse> getAll();
      PaymentMethodResponse getById(Integer id);
      PaymentMethodResponse create(PaymentMethodRequest request);
      PaymentMethodResponse update(Integer id, PaymentMethodRequest request);
      void delete(Integer id);
}
