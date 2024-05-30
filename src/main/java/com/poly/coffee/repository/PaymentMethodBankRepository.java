package com.poly.coffee.repository;

import com.poly.coffee.entity.PaymentMethodBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodBankRepository extends JpaRepository<PaymentMethodBank, Long> {
}
