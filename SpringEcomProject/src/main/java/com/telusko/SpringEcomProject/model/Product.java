package com.telusko.SpringEcomProject.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @JsonProperty(access = JsonProperty.Access.READ_ONLY) // ✅ ignore from incoming JSON

    private  int id;
    private String name;
    private String description;
    private String  brand;
    private BigDecimal price;
    private String category;
    private boolean productAvailable;
    private Date releaseDate;
    private int stockQuantity;

    //for Add Image with products
    private String imageName;
    private String imageType;

    @Lob
    private byte[] imageData;

//handle Http Method create constructor
   public Product(int id){
        this.id=id;
    }


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
}
