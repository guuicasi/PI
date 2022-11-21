package com.mycompany.perfumaria.model;

import com.mycompany.perfumaria.interfaces.PersonInterface;

public class Person {
    public long id;
    public String name;
    public String gender;
    public String email;
    public String cpf;
    public String password;
    public Address address;
    public String type;
    public String smartphone;
    
    public long getId() {
        return id;
    }

    public String getSmartphone() {
        return smartphone;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public String getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSmartphone(String smartphone) {
        this.smartphone = smartphone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }
}


