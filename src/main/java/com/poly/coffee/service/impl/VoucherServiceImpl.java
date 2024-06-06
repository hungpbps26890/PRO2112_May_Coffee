package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.VoucherRequest;
import com.poly.coffee.dto.response.VoucherResponse;
import com.poly.coffee.entity.Voucher;
import com.poly.coffee.mapper.VoucherMapper;
import com.poly.coffee.repository.VoucherRepository;
import com.poly.coffee.service.VoucherService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoucherServiceImpl implements VoucherService {

    VoucherRepository repository;
    VoucherMapper mapper;


    @Override
    public List<VoucherResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toVoucherResponse)
                .collect(Collectors.toList());
    }

    @Override
    public VoucherResponse getById(Integer id) {
        return mapper.toVoucherResponse(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not get voucher!")));
    }

    @Override
    public VoucherResponse create(VoucherRequest request) {
        return mapper.toVoucherResponse(repository.save(mapper.toVoucher(request)));
    }

    @Override
    public VoucherResponse update(Integer id, VoucherRequest request) {
        Voucher Voucher = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not update voucher!"));
        mapper.updateVoucher(Voucher, request);
        return mapper.toVoucherResponse(repository.save(Voucher));
    }

    @Override
    public void delete(Integer id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can not delete voucher!")));
    }
}
