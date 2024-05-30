package com.poly.coffee.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "payment_method_banks")
public class PaymentMethodBank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String owner;
    String creditCard;
    Float totalPrice;
    LocalDateTime date;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentMethodId", referencedColumnName = "id")
    PaymentMethod paymentMethod;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "bankId", referencedColumnName = "id")
    Bank bank;
}
