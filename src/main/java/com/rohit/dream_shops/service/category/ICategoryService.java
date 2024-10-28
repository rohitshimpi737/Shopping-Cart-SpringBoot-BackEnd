package com.rohit.dream_shops.service.category;
import com.rohit.dream_shops.model.Category;


import java.util.List;


public interface ICategoryService {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category updateCategory(Category category, Long id);
    void deleteCategoryById(Long id);
}
