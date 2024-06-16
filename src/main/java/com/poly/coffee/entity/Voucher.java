package com.poly.coffee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "vouchers")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(length = 20, nullable = false)
    String discountCode;
    @Column(nullable = false)
    @Positive
    Float amount;
    @Column(nullable = false)
    LocalDateTime beginDate;
    @Column(nullable = false)
    LocalDateTime endDate;
    String image;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "voucher_type_id", referencedColumnName = "id")
    VoucherType voucherType;
    @JsonIgnore
    @OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<OrderDetail> orderDetails = new ArrayList<>();
}
