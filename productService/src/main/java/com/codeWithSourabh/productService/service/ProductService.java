package com.codeWithSourabh.productService.service;

import com.codeWithSourabh.productService.dtos.GenericProductDto;


import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto);

    List<GenericProductDto> getAllProducts();
}
