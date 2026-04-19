package com.SpringRestAPI.Controllers;

import com.SpringRestAPI.Exceptions.InvalidPriceRangeException;
import com.SpringRestAPI.Exceptions.MissingApiKeyException;
import com.SpringRestAPI.Exceptions.ProductNotFoundException;
import com.SpringRestAPI.Models.Product;
import com.SpringRestAPI.Models.ProductCategories;
import com.SpringRestAPI.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            throw new MissingApiKeyException("API-Key header is missing or invalid");
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
            throw new MissingApiKeyException("API-Key header is missing or invalid");
        }
        Logger myLogger = Logger.getLogger("ProductList");
        myLogger.info("Get all the Product list");

        return productService.getProductList();
    }

    // get all products by name
    @GetMapping("/products/{productName}")
    public ResponseEntity<?> getProductByName(
            @RequestHeader(value="API-Key", required=false) String apiKey,
            @PathVariable String productName) {
        try {
            if (!"123456".equals(apiKey)) {
                throw new MissingApiKeyException("API-Key header is missing or invalid");
            }
            List<Product> products = productService.getProductByName(productName);
            if (products.isEmpty()) {
                throw new ProductNotFoundException("No product found with that name");
            }
            return ResponseEntity.status(HttpStatus.OK).body(products);

        } catch (MissingApiKeyException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("API-Key header is missing or invalid");
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found with that name");
        }
    }

    // change product name
    @PutMapping("/products/{productName}/{newName}") // http://localhost:8080/api/products/{name}/{newName}
    public Product updateProductName(
            @PathVariable String productName,
            @PathVariable String newName,
            @RequestHeader("API-Key") String apiKey) {
        if (!"123456".equals(apiKey)) {
            throw new MissingApiKeyException("API-Key header is missing or invalid");
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
            throw new MissingApiKeyException("API-Key header is missing or invalid");
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
    public ResponseEntity<?> getProductsByPriceRange(
            @RequestParam double min,
            @RequestParam double max,
            @RequestHeader(value="API-Key", required=false) String apiKey) {

        try {
            if (!"123456".equals(apiKey)) {
                throw new MissingApiKeyException("API-Key header is missing or invalid");
            }
            if (min > max) {
                throw new InvalidPriceRangeException("Min price cannot be greater than max price");
            }
            List<Product> products = productService.getProductsByPriceRange(min, max);
            if  (products == null || products.isEmpty()) {
                throw new ProductNotFoundException("No product found in this price range");
            }
            return ResponseEntity.status(HttpStatus.OK).body(products);

        } catch (MissingApiKeyException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("API-Key header is missing or invalid");
        } catch (InvalidPriceRangeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Min price cannot be greater than max price");
        } catch (ProductNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No product found in this price range");
        }

    }
}
