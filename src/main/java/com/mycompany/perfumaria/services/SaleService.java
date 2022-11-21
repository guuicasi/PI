package com.mycompany.perfumaria.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mycompany.perfumaria.interfaces.SaleInterface;
import com.mycompany.perfumaria.model.Product;
import com.mycompany.perfumaria.model.Sale;
import com.mycompany.perfumaria.services.Connection.ConnectionDB;

public class SaleService implements SaleInterface {

    private static final SaleProductsService saleProductsService = new SaleProductsService();

    @Override
    public void delete(long id) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("DELETE TB_SALES WHERE ID = ?");

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
    public void insert(Sale sale) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("INSERT INTO TB_SALES (CLIENT_ID, STATUS, TOTAL_VALUE) VALUES (?, ?,?)");

            sqlCommand.setLong(1, sale.getIdClient());
            sqlCommand.setString(2, sale.getStatus() );
            sqlCommand.setDouble(3, sale.getTotal());

            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }

            Sale newSale = getLastSaleByClientId(sale.getIdClient());

            for (Product product : sale.getProducts()) {
                saleProductsService.insert(product, newSale.getIdSale());
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Sale update(Sale sale) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("UPDATE TB_SALES SET STATUS = ?', TOTAL_VALUE = ?  WHERE ID = ?");

            sqlCommand.setString(1, sale.getStatus() );
            sqlCommand.setDouble(2, sale.getTotal());
            sqlCommand.setLong(3, sale.getIdSale());
        
            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sale; 
    }

    @Override
    public Sale get(long id) {
        Sale sale = new Sale();

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("SELECT * FROM TB_SALES WHERE ID = ?");

            sqlCommand.setLong(1, id);

            ResultSet rs = sqlCommand.executeQuery(); 

            if (rs == null) {
                throw new SQLException();
            }

            sale.setId(rs.getLong("ID"));
            sale.setIdClient(rs.getLong("CLIENT_ID"));
            sale.setStatus(rs.getString("STATUS"));
            sale.setTotal(rs.getDouble("TOTAL_VALUE"));

            List<Product> products = saleProductsService.getBySaleId(sale.getIdSale());

            sale.setProducts(products);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sale;
    }



    @Override
    public Sale getLastSaleByClientId(long clientId) {
        Sale sale = new Sale();

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("SELECT  * FROM TB_SALES WHERE CLIENT_ID = ? ORDER BY ID DESC LIMIT 1");

            sqlCommand.setLong(1, clientId);

            ResultSet rs = sqlCommand.executeQuery(); 

            if (rs == null) {
                throw new SQLException();
            }

            while(rs.next()) {
                sale.setId(rs.getLong("ID"));
                sale.setIdClient(rs.getLong("CLIENT_ID"));
                sale.setStatus(rs.getString("STATUS"));
                sale.setTotal(rs.getDouble("TOTAL_VALUE"));
            }

            List<Product> products = saleProductsService.getBySaleId(sale.getIdSale());

            sale.setProducts(products);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sale;
    }
}
