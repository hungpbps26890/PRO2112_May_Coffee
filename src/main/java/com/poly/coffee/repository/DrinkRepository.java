package com.poly.coffee.repository;

import com.poly.coffee.entity.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {

    List<Drink> findByCategoryIdAndIsActive(Long categoryId, boolean isActive);

    List<Drink> findByIsActive(boolean isActive);
}
