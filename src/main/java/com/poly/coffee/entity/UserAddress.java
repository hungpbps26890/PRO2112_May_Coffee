package com.poly.coffee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.poly.coffee.model.UserAddressKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@SuppressWarnings("serial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "user_addresses")
public class UserAddress implements Serializable {
	
	@EmbeddedId
	private UserAddressKey id;

	private Boolean isDefault;

	@JsonIgnore
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@MapsId("addressId")
	@JoinColumn(name = "address_id")
	private Address address;

}
