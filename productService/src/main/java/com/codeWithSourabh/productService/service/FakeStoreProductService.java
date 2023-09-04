package com.codeWithSourabh.productService.service;

import com.codeWithSourabh.productService.dtos.FakeStoreProductDto;
import com.codeWithSourabh.productService.dtos.GenericProductDto;
import com.codeWithSourabh.productService.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public GenericProductDto getProductById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getProductRequestUrl, FakeStoreProductDto.class, id);
        response.getStatusCode();

        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        GenericProductDto product = new GenericProductDto(
               fakeStoreProductDto.getTitle(),
                fakeStoreProductDto.getDescription(),
                fakeStoreProductDto.getImage(),
                fakeStoreProductDto.getPrice(),
                fakeStoreProductDto.getCategory(),
                0l
        );
        return product;


    }

    public GenericProductDto createProduct(GenericProductDto product){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(createProductRequestUrl, product, GenericProductDto.class);
//        response.getStatusCode();


        return response.getBody();

//        return

    }
}
