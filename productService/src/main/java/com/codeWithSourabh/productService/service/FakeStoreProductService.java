package com.codeWithSourabh.productService.service;

import com.codeWithSourabh.productService.dtos.FakeStoreProductDto;
import com.codeWithSourabh.productService.dtos.GenericProductDto;
import com.codeWithSourabh.productService.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
//    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;
    private String getProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private String createProductRequestUrl = "https://fakestoreapi.com/products";

//    private final String getAllProductUrl = ""

    //Spring will automatically inject object of RestTemplateBuilder

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public GenericProductDto getProductById(Long id){
//        RestTemplate restTemplate = restTemplateBuilder.build();
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
//        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(createProductRequestUrl, product, FakeStoreProductDto.class);
//        response.getStatusCode();
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        GenericProductDto genericProductDto = new GenericProductDto(
                fakeStoreProductDto.getTitle(),
                fakeStoreProductDto.getDescription(),
                fakeStoreProductDto.getImage(),
                fakeStoreProductDto.getPrice(),
                fakeStoreProductDto.getCategory(),
                fakeStoreProductDto.getId()
        );
        return genericProductDto;

//        return

    }

    public GenericProductDto deleteProductById(Long id){
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(getProductRequestUrl, HttpMethod.DELETE, null,FakeStoreProductDto.class, id);
//        restTemplate.delete(getProductRequestUrl,id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        GenericProductDto genericProductDto = new GenericProductDto(
                fakeStoreProductDto.getTitle(),
                fakeStoreProductDto.getDescription(),
                fakeStoreProductDto.getImage(),
                fakeStoreProductDto.getPrice(),
                fakeStoreProductDto.getCategory(),
                fakeStoreProductDto.getId()
        );

        return genericProductDto;

    }

    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto){
        HttpEntity<GenericProductDto> request = new HttpEntity<GenericProductDto>(genericProductDto);


        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(getProductRequestUrl, HttpMethod.PUT, request, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        GenericProductDto genericProductDtoToReturn = new GenericProductDto(
                fakeStoreProductDto.getTitle(),
                fakeStoreProductDto.getDescription(),
                fakeStoreProductDto.getImage(),
                fakeStoreProductDto.getPrice(),
                fakeStoreProductDto.getCategory(),
                fakeStoreProductDto.getId()
        );

        return genericProductDtoToReturn;

    }

    public List<GenericProductDto> getAllProducts(){
        ResponseEntity<FakeStoreProductDto []> response =      restTemplate.getForEntity(createProductRequestUrl,FakeStoreProductDto[].class);
        FakeStoreProductDto[] products = response.getBody();
        List<GenericProductDto> allProducts = new ArrayList<>();

        for(FakeStoreProductDto product : products ){
            allProducts.add(
                    new GenericProductDto(

                            product.getTitle(),
                            product.getDescription(),
                            product.getImage(),
                            product.getPrice(),
                            product.getCategory(),
                            product.getId()
                    )
            );
        }
    return allProducts;
    }
}
