package com.mycompany.perfumaria.model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    long id;
    long idClient;
    List<Product> products;
    String status;
    double total;

    public long getIdSale() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public long getIdClient() {
        return idClient;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getStatus() {
        return status;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
