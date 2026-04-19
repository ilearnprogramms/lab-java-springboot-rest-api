package com.SpringRestAPI.Models;

public class Product {

    String productName;
    double productPrice;
    ProductCategories productCategory;
    int productQuantity;

    public Product(String productName, double productPrice, ProductCategories productCategory, int productQuantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName() {
        if (productName.length() >= 3) {
            this.productName = productName;
        }
        else  {
            System.out.println("Product name must contain at least 3 characters.");
        }
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        if (productPrice >= 0) {
            this.productPrice = productPrice;
        }
        else  {
            System.out.println("Product price cannot be negative.");
        }
    }

    public ProductCategories getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategories productCategory) {
        if (productCategory != null) {
            this.productCategory = productCategory;
        }
        else {
            System.out.println("Product category cannot be empty.");
        }
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        if (productQuantity >= 0) {
            this.productQuantity = productQuantity;
        }
        else  {
            System.out.println("Product quantity cannot be negative.");
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory=" + productCategory +
                ", productQuantity=" + productQuantity +
                '}';
    }
}
