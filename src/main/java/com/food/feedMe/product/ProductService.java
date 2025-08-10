package com.food.feedMe.product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    ProductDto getProductByName(String productName);

}
