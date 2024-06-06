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
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Float totalPrice;
    String userName;
    LocalDateTime createDate;
    Integer paymentStatus;
    Integer tableNumber;
    Integer deliveryCharge;
    Long paymentMethodBankId;
    Integer orderStatusId;
    //payment_method_bank_id
    //user_id
    //address_id
}
