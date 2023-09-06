package com.codeWithSourabh.productService.dtos;

import com.codeWithSourabh.productService.models.Category;
import lombok.Getter;
import lombok.Setter;

//this dto is used to get and return the response from the client. it's available to outside world. recall publish applicatin analogy by biswajeet.
@Getter
@Setter
public class GenericProductDto {
    private String title;
    private Long id;
    private String description;
    private String image;
    private double price;
    private String category;

    public GenericProductDto(String title, String description, String image, double price, String category, Long id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.price = price;
        this.category = category;
    }



//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }
//
//    public double getPrice() {
//        return price;
//    }
//
//    public void setPrice(double price) {
//        this.price = price;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
}
