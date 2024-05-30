package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.BankRequest;
import com.poly.coffee.dto.response.BankResponse;
import com.poly.coffee.entity.Bank;
import com.poly.coffee.mapper.BankMapper;
import com.poly.coffee.repository.BankRepository;
import com.poly.coffee.service.BankService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BankServiceImpl implements BankService {

    BankRepository repository;
    BankMapper  mapper;


    @Override
    public List<Bank> getAll() {
        return repository.findAll();
    }

    @Override
    public BankResponse getById(Integer id) {
        return mapper.toBankResponse(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not get bank!")));
    }

    @Override
    public BankResponse create(BankRequest  request) {
        return mapper.toBankResponse(repository.save(mapper.toBank(request)));
    }

    @Override
    public BankResponse update(Integer id, BankRequest request) {
        Bank bank = repository.findById(id).orElseThrow(() -> new RuntimeException("Can not update bank!"));
        mapper.updateBank(bank, request);
        return mapper.toBankResponse(repository.save(bank));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not delete bank!")));
    }
}
