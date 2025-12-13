package com.mohcode.dream.shops.service.product;

import com.mohcode.dream.shops.model.Product;
import com.mohcode.dream.shops.request.AddProductRequest;
import com.mohcode.dream.shops.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest request);

    Product getProductById(long id);
    Product updateProduct(long id, Product product);

    Product updateProduct(ProductUpdateRequest product, Long productId);

    void deleteProductById(long id);

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String name);


}
