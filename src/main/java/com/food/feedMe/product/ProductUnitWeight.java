package com.food.feedMe.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class ProductUnitWeight {

    @Id
    private Long productId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private String unit;
    private Double weightInGrams;

}
