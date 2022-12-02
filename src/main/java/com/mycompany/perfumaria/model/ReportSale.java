package com.mycompany.perfumaria.model;

import java.util.List;

public class ReportSale {
    long id;
    String status;
    double total;
    String cpf;
    List<Product> products;

    public long getIdSale() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public String getCpf() {
        return cpf;
    }

    public String getStatus() {
        return status;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
