package com.codeWithSourabh.productService.controller;

import com.codeWithSourabh.productService.dtos.FakeStoreProductDto;
import com.codeWithSourabh.productService.dtos.GenericProductDto;
import com.codeWithSourabh.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController()
@RequestMapping("/products/")
public class ProductController {

        //Field level injection
//        @Autowired
        private ProductService productService;



//        dependancy injection by constructor -- recommended.
        // no need to write autowired keyword here. in the latest spring version
        public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
                this.productService = productService;
        } // here we are telling SPring to put object for productService but let say if you have more than one
        //implementation of the productService then it will be confused.. so the solution is @Qualifier

// Setter Injection
//        @Autowired
//        public void setProductService(ProductService productService)
//        {
//                this.productService = productService;
//        }
//
        @GetMapping
        public void getAllProducts(){

        }

        @GetMapping("{id}")
        public GenericProductDto getProductById(@PathVariable(value = "id") Long id){


            return productService.getProductById(id);

        }

        @DeleteMapping("{id}")
        public void deleteProductById(){

        }

        @PostMapping
        public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
//                System.out.println(genericProductDto.getTitle());
                return productService.createProduct(genericProductDto);

        }


        @PutMapping("{id}")
        public void updateProductById(){

        }
}
