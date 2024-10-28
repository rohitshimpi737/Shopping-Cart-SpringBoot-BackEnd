package com.rohit.dream_shops.request;

import com.rohit.dream_shops.model.Category;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class AddProductRequest {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
}