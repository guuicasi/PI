package com.mycompany.perfumaria.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.perfumaria.interfaces.ProductInterface;
import com.mycompany.perfumaria.model.Product;
import com.mycompany.perfumaria.services.Connection.ConnectionDB;

public class ProductService implements ProductInterface {

    @Override
    public void delete(long id) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("DELETE FROM TB_PRODUCTS WHERE ID = ?");

            sqlCommand.setLong(1, id);

            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insert(Product product) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("INSERT INTO TB_PRODUCTS (NM_PROD, PRICE, QT_PROD) VALUES (?, ?, ?)");

            sqlCommand.setString(1, product.getName());
            sqlCommand.setDouble(2, product.getPrice());
            sqlCommand.setInt(3, product.getQuantity());

            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product update(Product product) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("UPDATE TB_PRODUCTS SET NM_PROD = ?, PRICE = ?, QT_PROD = ? WHERE ID = ?");
        
            sqlCommand.setString(1, product.getName());
            sqlCommand.setDouble(2, product.getPrice());
            sqlCommand.setInt(3, product.getQuantity()); 
            sqlCommand.setLong(4, product.getId());
        
            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product; 
    }

    @Override
    public Product get(long id) {
        Product product = new Product();

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("SELECT * FROM TB_PRODUCTS WHERE ID = ?");

            sqlCommand.setLong(1, id);

            ResultSet rs = sqlCommand.executeQuery();  

            if (rs == null) {
                throw new SQLException();
            }

            product.setId(rs.getLong("ID"));
            product.setName(rs.getString("NM_PROD"));
            product.setPrice(rs.getDouble("PRICE"));
            product.setQuantity(rs.getInt("QT_PROD"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("SELECT * FROM TB_PRODUCTS");
            ResultSet rs = sqlCommand.executeQuery();  

            if (rs == null) {
                throw new SQLException();
            }

            while(rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("ID"));
                product.setName(rs.getString("NM_PROD"));
                product.setPrice(rs.getDouble("PRICE"));
                product.setQuantity(rs.getInt("QT_PROD"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    
}
