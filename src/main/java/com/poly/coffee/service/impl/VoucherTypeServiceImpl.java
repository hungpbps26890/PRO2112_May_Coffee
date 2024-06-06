package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.VoucherTypeRequest;
import com.poly.coffee.dto.response.VoucherTypeResponse;
import com.poly.coffee.entity.VoucherType;
import com.poly.coffee.mapper.VoucherTypeMapper;
import com.poly.coffee.repository.VoucherTypeRepository;
import com.poly.coffee.service.VoucherTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoucherTypeServiceImpl implements VoucherTypeService {

    VoucherTypeRepository repository;
    VoucherTypeMapper mapper;


    @Override
    public List<VoucherTypeResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toVoucherTypeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public VoucherTypeResponse getById(Integer id) {
        return mapper.toVoucherTypeResponse(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not get voucher type!")));
    }

    @Override
    public VoucherTypeResponse create(VoucherTypeRequest request) {
        return mapper.toVoucherTypeResponse(repository.save(mapper.toVoucherType(request)));
    }

    @Override
    public VoucherTypeResponse update(Integer id, VoucherTypeRequest request) {
        VoucherType VoucherType = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not update voucher type!"));
        mapper.updateVoucherType(VoucherType, request);
        return mapper.toVoucherTypeResponse(repository.save(VoucherType));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not delete voucher type!")));
    }
}
