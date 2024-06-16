package com.poly.coffee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String streetnumber;

	private String ward;

	private String district;

	private String province;
	
	@JsonIgnore
	@OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<UserAddress> userAddresses = new ArrayList<>();
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "address")
//	private List<Order> orders;
}
