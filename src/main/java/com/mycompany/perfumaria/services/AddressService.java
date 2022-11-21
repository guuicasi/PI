package com.mycompany.perfumaria.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycompany.perfumaria.interfaces.AddressInterface;
import com.mycompany.perfumaria.model.Address;
import com.mycompany.perfumaria.services.Connection.ConnectionDB;

public class AddressService implements AddressInterface{

    @Override
    public void delete(long id) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("DELETE TB_ADDRESS WHERE ID = ?");
            sqlCommand.setLong(1, id );

            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Address address) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("INSERT INTO TB_ADDRESS (NM_ADDRESS, NR_ADDRESS, CEP, CITY, COMPLEMENT, DISTRICT, STATE, CLIENT_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            sqlCommand.setString(1, address.getAddressName());
            sqlCommand.setInt(2, address.getNum());
            sqlCommand.setString(3, address.getCep()); 
            sqlCommand.setString(4, address.getCity());
            sqlCommand.setString(5, address.getComplement());
            sqlCommand.setString(6, address.getDistrict());
            sqlCommand.setString(7, address.getState());
            sqlCommand.setLong(8, address.getClientId() );
            
            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Address update(Address address) {

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("UPDATE TB_ADDRESS SET NM_ADDRESS = ?, NR_ADDRESS = ?, CEP = ?, CITY = ?, COMPLEMENT = ?, DISTRICT = ?, STATE = ?, CLIENT_ID = ? WHERE ID = ?" );
            sqlCommand.setString(1, address.getAddressName());
            sqlCommand.setInt(2, address.getNum());
            sqlCommand.setString(3, address.getCep()); 
            sqlCommand.setString(4, address.getCity());
            sqlCommand.setString(5, address.getComplement());
            sqlCommand.setString(6, address.getDistrict());
            sqlCommand.setString(7, address.getState());
            sqlCommand.setLong(7, address.getClientId() );
            sqlCommand.setLong(8, address.getId());
            
            int affectedLines = sqlCommand.executeUpdate();
                    
            if (affectedLines <= 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address; 
    }

    @Override
    public Address getByClientId(long clientId) {
        Address address = new Address();

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("SELECT * FROM TB_ADDRESS WHERE CLIENT_ID = ?");

            sqlCommand.setLong(1, clientId);

            ResultSet rs = sqlCommand.executeQuery();       

            if (rs == null) {
                throw new SQLException();
            }

            while(rs.next()) {
                address.setId(rs.getLong("ID"));
                address.setAddressName(rs.getString("NM_ADDRESS"));
                address.setNum(rs.getInt("NR_ADDRESS"));
                address.setCep(rs.getString("CEP"));
                address.setCity(rs.getString("CITY"));
                address.setComplement(rs.getString("COMPLEMENT"));
                address.setDistrict(rs.getString("DISTRICT"));
                address.setState(rs.getString("STATE"));
                address.setClientId(rs.getLong("CLIENT_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return address;
    }
    
}
