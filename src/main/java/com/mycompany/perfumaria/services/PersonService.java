package com.mycompany.perfumaria.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycompany.perfumaria.interfaces.PersonInterface;
import com.mycompany.perfumaria.model.Address;
import com.mycompany.perfumaria.model.Person;
import com.mycompany.perfumaria.services.Connection.ConnectionDB;

public class PersonService implements PersonInterface {
    AddressService addressService = new AddressService();

    @Override
    public void delete(long id) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("DELETE TB_CLIENT_INFO WHERE ID = ?");

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
    public void insert(Person person) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("INSERT INTO TB_CLIENT_INFO (NM_CLIE, EMAIL, CPF, PASSWORD, TP_CLIE, GENDER, NR_PHONE) VALUES (?, ?, ?, ?, ?, ?, ?)");
            sqlCommand.setString(1, person.getName());
            sqlCommand.setString(2, person.getEmail());
            sqlCommand.setString(3, person.getCpf()); 
            sqlCommand.setString(4, person.getPassword() );
            sqlCommand.setString(5, person.getType());
            sqlCommand.setString(6, person.getGender());
            sqlCommand.setString(7, person.getSmartphone());

            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }

            Person newPerson = getByCpf(person.getCpf());

            person.getAddress().setClientId(newPerson.getId());

            addressService.insert(person.address);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person update(Person person) {
        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("UPDATE TB_CLIENT_INFO SET NM_CLIE = ?, EMAIL = ?, CPF = ?, PASSWORD = ?, TP_CLIE = ?, GENDER = ? , NR_PHONE = ? WHERE ID = ?");

            sqlCommand.setString(1, person.getName());
            sqlCommand.setString(2, person.getEmail());
            sqlCommand.setString(3, person.getCpf()); 
            sqlCommand.setString(4, person.getPassword() );
            sqlCommand.setString(5, person.getType());
            sqlCommand.setString(6, person.getGender());
            sqlCommand.setString(7, person.getSmartphone());
            sqlCommand.setLong(8, person.getId());
        
            int affectedLines = sqlCommand.executeUpdate();

            if (affectedLines <= 0) {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person; 
    }

    @Override
    public Person login(String email, String password, String personType) {
        Person person = new Person();

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("SELECT CLIE.ID as CLIENT_ID, CLIE.NM_CLIE, CLIE.EMAIL, CLIE.CPF, CLIE.PASSWORD, CLIE.TP_CLIE, CLIE.GENDER, CLIE.NR_PHONE, ADRS.ID as ADDRESS_ID, ADRS.NM_ADDRESS, ADRS.NR_ADDRESS, ADRS.CEP, ADRS.CITY, ADRS.COMPLEMENT, ADRS.DISTRICT, ADRS.STATE " 
            + "FROM TB_CLIENT_INFO as CLIE "
            + "INNER JOIN TB_ADDRESS as ADRS "
            + "ON CLIE.ID = ADRS.CLIENT_ID "
            + "WHERE CLIE.EMAIL = ? AND CLIE.PASSWORD = ? AND CLIE.TP_CLIE = ?");
            
            sqlCommand.setString(1, email);
            sqlCommand.setString(2, password);
            sqlCommand.setString(3, personType);

            ResultSet rs = sqlCommand.executeQuery(); 

            if (rs == null) {
                throw new SQLException();
            }

            while (rs.next()) {
                person.setId(rs.getLong("CLIENT_ID"));
                person.setName(rs.getString("NM_CLIE"));
                person.setEmail(rs.getString("EMAIL"));
                person.setCpf(rs.getString("CPF"));
                person.setPassword(rs.getString("PASSWORD"));
                person.setType(rs.getString("TP_CLIE"));
                person.setGender(rs.getString("GENDER"));
                person.setSmartphone(rs.getString("NR_PHONE"));

                Address address = new Address();
                address.setId(rs.getLong("ADDRESS_ID"));
                address.setAddressName(rs.getString("NM_ADDRESS"));
                address.setNum(rs.getInt("NR_ADDRESS"));
                address.setCep(rs.getString("CEP"));
                address.setCity(rs.getString("CITY"));
                address.setComplement(rs.getString("COMPLEMENT"));
                address.setDistrict(rs.getString("DISTRICT"));
                address.setState(rs.getString("STATE"));
                address.setClientId(rs.getLong("CLIENT_ID"));

                person.setAddress(address);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Person getByCpf(String cpf) {
        Person person = new Person();

        try {
            Connection connection = ConnectionDB.getConnection();
            PreparedStatement sqlCommand = connection.prepareStatement("SELECT * FROM TB_CLIENT_INFO WHERE CPF = ?");

            sqlCommand.setString(1, cpf);

            ResultSet rs = sqlCommand.executeQuery(); 

            if (rs == null) {
                throw new SQLException();
            }

            while (rs.next()) {
                person.setId(rs.getLong("ID"));
                person.setName(rs.getString("NM_CLIE"));
                person.setEmail(rs.getString("EMAIL"));
                person.setCpf(rs.getString("CPF"));
                person.setPassword(rs.getString("PASSWORD"));
                person.setType(rs.getString("TP_CLIE"));
                person.setGender(rs.getString("GENDER"));
                person.setSmartphone(rs.getString("NR_PHONE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }
}
