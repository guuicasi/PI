package com.mycompany.perfumaria.interfaces;

import java.util.List;

import com.mycompany.perfumaria.model.Product;

public interface SaleProductsInterface {
    public List<Product> getBySaleId(long id);
    public void insert(Product product, long saleId);
}
