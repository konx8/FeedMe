package com.food.feedMe.product.impl;


import com.food.feedMe.exception.ProductNotFoundException;
import com.food.feedMe.product.Product;
import com.food.feedMe.product.ProductDto;
import com.food.feedMe.product.ProductRepository;
import com.food.feedMe.product.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl  implements ProductService {

    private ProductRepository productRepo;
    private ModelMapper modelMapper;

    public List<Product> getProducts(){
        return productRepo.findAll();
    }

    public ProductDto getProductByName(String productName){
        Product productByName = findProductByName(productName);
        return modelMapper.map(productByName, ProductDto.class);
    }

    private Product findProductByName(String productName){
        return productRepo.findByNamePl(productName)
                .orElseThrow(() -> new ProductNotFoundException("Product" + productName + "not founded"));
    }

}
