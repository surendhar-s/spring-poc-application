package com.cognizant.firstService.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CSVDataModel {

    private String productName;
    private Integer productQuantity;
    private Double productPrice;
    private Boolean productIsAvailable;

    public CSVDataModel() {
        super();
    }

    public CSVDataModel(String productName, Integer productQuantity, Double productPrice,
            Boolean productIsAvailable) {
        super();
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productIsAvailable = productIsAvailable;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getProductQuantity() {
        return this.productQuantity;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Double getProductPrice() {
        return this.productPrice;
    }

    public void setProductIsAvailable(Boolean productIsAvailable) {
        this.productIsAvailable = productIsAvailable;
    }

    public Boolean getProductIsAvailable() {
        return this.productIsAvailable;
    }

    @Override
    public String toString() {
        return "CSVDataModel [productIsAvailable=" + productIsAvailable + ", productName=" + productName
                + ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + "]";
    }

}