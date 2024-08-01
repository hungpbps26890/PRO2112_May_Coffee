package com.poly.coffee.repository;

import com.poly.coffee.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface VoucherRepository extends JpaRepository<Voucher, Long> {
    List<Voucher> findByBeginDateLessThanEqualAndEndDateGreaterThanEqual(LocalDateTime currentDate1, LocalDateTime currentDate2);
}
