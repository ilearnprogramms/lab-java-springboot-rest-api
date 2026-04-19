package com.SpringRestAPI.Controllers;

import com.SpringRestAPI.Models.Product;
import com.SpringRestAPI.Models.ProductCategories;
import com.SpringRestAPI.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class ProductController {


    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Create new product
    @PostMapping("/products") // http://localhost:8080/api/products/
    public Product addNewProduct(
            @RequestHeader("API-Key") String apiKey,
            @RequestBody Product product
            ) {
        if (!"123456".equals(apiKey)) {
            throw new RuntimeException("Invalid API Key");
        }
        Logger myLogger = Logger.getLogger("ProductController");
        myLogger.info("Create a new Product");

        return productService.addNewProduct(
                product.getProductName(),
                product.getProductPrice(),
                product.getProductCategory(),
                product.getProductQuantity()
        );
    }

    // get all products
    @GetMapping("/products") // http://localhost:8080/api/products/
    public List<Product> getAllProducts(@RequestHeader("API-Key") String apiKey) {
        if (!"123456".equals(apiKey)) {
            throw new RuntimeException("Invalid API Key");
        }
        Logger myLogger = Logger.getLogger("ProductList");
        myLogger.info("Get all the Product list");

        return productService.getProductList();
    }

    // get all products by name
    @GetMapping("/products/{productName}") // http://localhost:8080/api/products/{name}
    public List<Product> getProductByName(
            @RequestHeader("API-Key") String apiKey,
            @PathVariable String productName) {
        if (!"123456".equals(apiKey)) {
            throw new RuntimeException("Invalid API Key");
        }
        Logger myLogger = Logger.getLogger("ProductList by Name");
        myLogger.info("Get Product list by Name");

        return productService.getProductByName(productName);
    }

    // change product name
    @PutMapping("/products/{productName}/{newName}") // http://localhost:8080/api/products/{name}/{newName}
    public Product updateProductName(
            @PathVariable String productName,
            @PathVariable String newName,
            @RequestHeader("API-Key") String apiKey) {
        if (!"123456".equals(apiKey)) {
            throw new RuntimeException("Invalid API Key");
        }
        Logger myLogger = Logger.getLogger(" by Name");
        myLogger.info("change Product Name");

        return productService.updateProductName(productName, newName);
    }

    // delete product by name
    @DeleteMapping("/products/{productName}") // http://localhost:8080/api/products/{productName}
    public List<Product> deleteProduct(
            @PathVariable String productName,
            @RequestHeader("API-Key") String apiKey) {
        if (!"123456".equals(apiKey)) {
            throw new RuntimeException("Invalid API Key");
        }
        Logger myLogger = Logger.getLogger("ProductList by Name");
        myLogger.info("delete Product by Name");

        return productService.deleteProduct(productName);
    }

    // get item by category
    @GetMapping("/products/category/{category}") // http://localhost:8080/api/products/category/{category}
    public List<Product> getProductByCategory(
            @PathVariable ProductCategories category,
            @RequestHeader("API-Key") String apiKey) {
        if (!"123456".equals(apiKey)) {
            throw new RuntimeException("Invalid API Key");
        }
        Logger myLogger = Logger.getLogger("ProductList by Category");
        myLogger.info("get Product by Category");

        return productService.getProductByCategory(category);
    }

    // get products by price range
    @GetMapping("/products/price")
    public List<Product> getProductsByPriceRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice,
            @RequestHeader("API-Key") String apiKey) {
        if (!"123456".equals(apiKey)) {
            throw new RuntimeException("Invalid API Key");
        }
        Logger myLogger = Logger.getLogger("ProductList by Price range");
        myLogger.info("get Product by Price range");

        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }
}
