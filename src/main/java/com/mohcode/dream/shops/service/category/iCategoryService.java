package com.mohcode.dream.shops.service.category;

import com.mohcode.dream.shops.model.Category;

import java.util.List;

public interface iCategoryService {

    Category getCategoryByid(long id);

    Category getCategoryByName(String name);

    List<Category> getAllCategories();

    Category addCategory(Category category);

    Category updateCategory(Category category, long id);

    void deleteCategory(long id);

}
