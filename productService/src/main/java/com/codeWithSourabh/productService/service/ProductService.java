package com.codeWithSourabh.productService.service;

import com.codeWithSourabh.productService.dtos.GenericProductDto;
import com.codeWithSourabh.productService.models.Product;
import org.springframework.stereotype.Service;

public interface ProductService {
    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);
}
