package com.mycompany.perfumaria.interfaces;

import java.util.List;

import com.mycompany.perfumaria.model.Product;

public interface ProductInterface {
    public void delete(long id);
    public void insert(Product product);
    public Product update(Product product);
    public Product get(long id);
    public List<Product> getAllProducts();
}
