package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.PaymentMethodBankRequest;
import com.poly.coffee.dto.response.PaymentMethodBankResponse;
import com.poly.coffee.entity.PaymentMethodBank;
import com.poly.coffee.mapper.PaymentMethodBankMapper;
import com.poly.coffee.repository.PaymentMethodBankRepository;
import com.poly.coffee.service.PaymentMethodBankService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentMethodBankServiceImpl implements PaymentMethodBankService {

    PaymentMethodBankRepository repository;
    PaymentMethodBankMapper mapper;


    @Override
    public List<PaymentMethodBank> getAll() {
        return repository.findAll();
    }

    @Override
    public PaymentMethodBankResponse getById(Long id) {
        return mapper.toPaymentMethodBankResponse(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not get payment method bank!")));
    }

    @Override
    public PaymentMethodBankResponse create(PaymentMethodBankRequest request) {
        return mapper.toPaymentMethodBankResponse(repository.save(mapper.toPaymentMethodBank(request)));
    }

}
