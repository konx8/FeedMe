package com.food.feedMe.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductUnitWeightService {

    private final ProductUnitWeightRepo productUnitWeightRepo;

    public List<ProductUnitWeight> findProductWithCustomWeight() {

        return productUnitWeightRepo
                .findAll();

    }
}
