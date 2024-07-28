package com.poly.coffee.service.impl;

import com.poly.coffee.dto.request.ReportRequest;
import com.poly.coffee.dto.response.ReportResponse;
import com.poly.coffee.service.ReportService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReportServiceImpl implements ReportService {


    @Override
    public List<ReportResponse> getVouchersFromDateToDate(ReportRequest request) {
        return List.of();
    }
}
