package com.rohit.dream_shops.request;

import com.rohit.dream_shops.model.Category;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductUpdateRequest {
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;
    private Category category;
}
