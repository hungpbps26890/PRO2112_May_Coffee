package com.poly.coffee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer totalItems = 0;

    @ManyToOne
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    private Double totalPrice = 0.0;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    private Boolean paymentStatus = false;

    @ManyToOne
    @JoinColumn(name = "payment_method_id")
    private  PaymentMethod paymentMethod;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    @OneToOne(mappedBy = "order")
    private  PaymentMethodBank paymentMethodBank;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
