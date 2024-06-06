package com.poly.coffee.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer drinkQuantity;
    Float drinkUnitPrice;
    Integer toppingQuantity;
    Float toppingUnitPrice;
    String note;
    Integer toppingId;
    Integer voucherId;
    Integer drinkSizeId;
    Integer orderId;
}
