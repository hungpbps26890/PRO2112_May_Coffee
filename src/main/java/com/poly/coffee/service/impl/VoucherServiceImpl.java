package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.VoucherRequest;
import com.poly.coffee.dto.response.VoucherResponse;
import com.poly.coffee.entity.Voucher;
import com.poly.coffee.entity.VoucherType;
import com.poly.coffee.exception.AppException;
import com.poly.coffee.exception.ErrorCode;
import com.poly.coffee.mapper.VoucherMapper;
import com.poly.coffee.repository.VoucherRepository;
import com.poly.coffee.repository.VoucherTypeRepository;
import com.poly.coffee.service.VoucherService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VoucherServiceImpl implements VoucherService {

    VoucherRepository repository;
    VoucherMapper mapper;
    VoucherTypeRepository voucherTypeRepository;


    @Override
    public List<VoucherResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toVoucherResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<VoucherResponse> getValidByCurrentDate() {
        return repository.findByBeginDateLessThanEqualAndEndDateGreaterThanEqual(LocalDateTime.now(), LocalDateTime.now())
                .stream()
                .map(mapper::toVoucherResponse)
                .collect(Collectors.toList());
    }

    @Override
    public VoucherResponse getById(Long id) {
        return mapper.toVoucherResponse(repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND)));
    }

    @Override
    public VoucherResponse create(VoucherRequest request) {
        VoucherType voucherType = voucherTypeRepository.findById(request.getVoucherTypeId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        Voucher voucher = mapper.toVoucher((request));
        voucher.setVoucherType(voucherType);
        return mapper.toVoucherResponse(repository.save(voucher));
    }

    @Override
    public VoucherResponse update(Long id, VoucherRequest request) {
        VoucherType voucherType = voucherTypeRepository.findById(request.getVoucherTypeId())
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        Voucher voucher = repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND));
        mapper.updateVoucher(voucher, request);
        voucher.setVoucherType(voucherType);
        return mapper.toVoucherResponse(repository.save(voucher));
    }

    @Override
    public void delete(Long id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.NOT_FOUND)));
    }
}
