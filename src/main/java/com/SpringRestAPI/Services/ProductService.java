package com.SpringRestAPI.Services;

import com.SpringRestAPI.Models.Product;
import com.SpringRestAPI.Models.ProductCategories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private List<Product> productList;

    public ProductService() {
        setProductList();
    }

    public void setProductList (){
        productList = new ArrayList<>();

        productList.add(new Product("iPhone 17",879.00, ProductCategories.ELECTRONIC,5));
        productList.add(new Product("Hot Wheels Porsche",4.99, ProductCategories.TOYS,20));
        productList.add(new Product("Ado's Best Adobum",39.00, ProductCategories.MUSIC,3));
        productList.add(new Product("Howl's Moving Castle",27.50, ProductCategories.MOVIE,50));
        productList.add(new Product("The Hunger Games",19.90, ProductCategories.BOOKS,110));
    }

    // add a new product
    public boolean addNewProduct(String productName, double productPrice, ProductCategories productCategory, int productQuantity) {
        productList.add(new Product(productName, productPrice, productCategory, productQuantity));
        return true;
    }

    // get all products
    public List<Product> getProductList() {
        return productList;
    }

    // get products by name
    public List<Product> getProductByName(String productName) {
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                products.add(product);
            }
        }
        return products;
    }

    // update product
    public Product updateProductName(String currentName, String newName) {
        for (Product product : productList) {
            if (product.getProductName().equalsIgnoreCase(currentName)) {
                product.setProductName();
                return product;
            }
        }
        throw new RuntimeException("Product not found");
    }

    // delete product
    public List<Product> deleteProduct (String productName){
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                productList.remove(product);
            }
        }
        return productList;
    }

    // get products by category
    public List<Product> getProductByCategory (ProductCategories productCategory){
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductCategory().equals(productCategory)) {
                products.add(product);
            }
        }
        return products;
    }

    // get products by price range
    public List<Product> getProductsByPriceRange (double minPrice, double maxPrice){
        List<Product> products = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductPrice()>=minPrice&&product.getProductPrice()<=maxPrice) {
                products.add(product);
            }
        }
        return products;
    }

}
