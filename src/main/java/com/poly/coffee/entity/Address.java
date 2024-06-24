package com.poly.coffee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(255)")
    private String streetNumber;

    @Column(columnDefinition = "nvarchar(255)")
    private String ward;

    @Column(columnDefinition = "nvarchar(255)")
    private String district;

    @Column(columnDefinition = "nvarchar(255)")
    private String province;

    @JsonIgnore
    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserAddress> userAddresses = new ArrayList<>();
}
