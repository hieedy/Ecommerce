package com.codeWithSourabh.productService.controller;

import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/products/")
public class ProductController {

        @GetMapping
        public void getAllProducts(){

        }

        @GetMapping("{id}")
        public String getProductById(@PathVariable(value = "id") Long id){

            return "Helloo!! Here is product id: "+id;

        }

        @DeleteMapping("{id}")
        public void deleteProductById(){

        }

        @PostMapping("{id}")
        public void createProductById(){

        }


        @PutMapping("{id}")
        public void updateProductById(){

        }
}
