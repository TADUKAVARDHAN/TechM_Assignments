package com.web.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

    @Id
    private String id;
    private String vendorCode;
    private String prodName;
    private Double prodCost;

    // Default Constructor
    public Product() {}

    // Constructor
    public Product(String id, String vendorCode, String prodName, Double prodCost) {
        this.id = id;
        this.vendorCode = vendorCode;
        this.prodName = prodName;
        this.prodCost = prodCost;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Double getProdCost() {
        return prodCost;
    }

    public void setProdCost(Double prodCost) {
        this.prodCost = prodCost;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", vendorCode=" + vendorCode + ", prodName=" + prodName + ", prodCost=" + prodCost + "]";
    }
}
