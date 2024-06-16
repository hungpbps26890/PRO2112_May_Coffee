package com.poly.coffee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(length = 10, nullable = false)
    String name;
    @JsonIgnore
    @OneToMany(mappedBy = "paymentMethod", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<PaymentMethodBank> paymentMethodBanks;
}
