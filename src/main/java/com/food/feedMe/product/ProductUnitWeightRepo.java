package com.food.feedMe.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductUnitWeightRepo extends JpaRepository<ProductUnitWeight, Long> {

}
