package com.mycompany.perfumaria.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.perfumaria.interfaces.SaleProductsInterface;
import com.mycompany.perfumaria.model.Product;
import com.mycompany.perfumaria.services.Connection.ConnectionDB;

public class SaleProductsService implements SaleProductsInterface{

    @Override
    public List<Product> getBySaleId(long id) {
        List<Product> products = new ArrayList<Product>();
        
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("SELECT * FROM TB_SALE_PRODUCTS WHERE SALE_ID = ?");

            sqlCommand.setLong(1, id);

            ResultSet rs = sqlCommand.executeQuery(); 

            if (rs == null) {
                throw new SQLException();
            }

            while (rs.next()) {
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

    @Override
    public void insert(Product product, long saleId) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("INSERT INTO TB_SALE_PRODUCTS (SALE_ID, PRODUCT_ID, QT_PROD) VALUES (?, ?, ?)");

            sqlCommand.setLong(1, saleId);
            sqlCommand.setLong(2, product.getId());
            sqlCommand.setLong(3, product.getQuantity());

            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
