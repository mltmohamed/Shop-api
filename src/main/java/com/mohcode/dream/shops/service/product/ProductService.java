package com.mohcode.dream.shops.service.product;

import com.mohcode.dream.shops.exceptions.ProductNotFoundException;
import com.mohcode.dream.shops.model.Category;
import com.mohcode.dream.shops.model.Product;
import com.mohcode.dream.shops.repository.ProductRepository;
import com.mohcode.dream.shops.request.AddProductRequest;

import java.util.List;

public class ProductService implements IProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(AddProductRequest request) {
        return null;
    }
    private Product createProduct(AddProductRequest request, Category category){
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getPrice(),
                request.getInventory(),
                request.getDescription(),
                category
        );
    }

    @Override
    public Product getProductById(long id) {
        return productRepository
                .findById(id)
                .orElseThrow((new ProductNotFoundException("Produit non trouvé avec l'ID: " + id));
    }

    @Override
    public Product updateProduct(long id, Product product) {
        return null;
    }

    @Override
    public void deleteProductById(long id) {
        productRepository
                    .findById(id)
                    .ifPresentOrElse(productRepository::delete,
                            () -> {throw new ProductNotFoundException("Produit non trouvé avec l'ID: " + id);});
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        return productRepository.findByCategoryNameAndBrand(category, brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return productRepository.CountByBrandAndName(brand, name);
    }
}
