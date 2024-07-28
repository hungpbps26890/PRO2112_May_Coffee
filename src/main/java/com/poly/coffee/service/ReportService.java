package com.poly.coffee.service;

import com.poly.coffee.dto.request.ReportRequest;
import com.poly.coffee.dto.response.ReportResponse;

import java.util.List;

public interface ReportService {
      List<ReportResponse> getVouchersFromDateToDate(ReportRequest request);
}
