package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.PaymentMethodRequest;
import com.poly.coffee.dto.response.PaymentMethodResponse;
import com.poly.coffee.entity.PaymentMethod;
import com.poly.coffee.mapper.PaymentMethodMapper;
import com.poly.coffee.repository.PaymentMethodRepository;
import com.poly.coffee.service.PaymentMethodService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentMethodServiceImpl implements PaymentMethodService {

    PaymentMethodRepository repository;
    PaymentMethodMapper mapper;


    @Override
    public List<PaymentMethod> getAll() {
        return repository.findAll();
    }

    @Override
    public PaymentMethodResponse  getById(Integer id) {
        return mapper.toPaymentMethodResponse(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not get payment method!")));
    }

    @Override
    public PaymentMethodResponse create(PaymentMethodRequest  request) {
        return mapper.toPaymentMethodResponse(repository.save(mapper.toPaymentMethod(request)));
    }

    @Override
    public PaymentMethodResponse update(Integer id, PaymentMethodRequest request) {
        PaymentMethod paymentMethod = repository.findById(id)
                                                .orElseThrow(() -> new RuntimeException("Can not update payment method!"));
        mapper.updatePaymentMethod(paymentMethod, request);
        return mapper.toPaymentMethodResponse(repository.save(paymentMethod));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not delete payment method!")));
    }
}
