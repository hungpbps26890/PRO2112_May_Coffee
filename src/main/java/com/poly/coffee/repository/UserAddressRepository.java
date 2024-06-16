package com.poly.coffee.repository;




import com.poly.coffee.entity.UserAddress;
import com.poly.coffee.model.UserAddressKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, UserAddressKey> {
    List<UserAddress> findByUserId(Long userId);
}
