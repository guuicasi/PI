package com.mycompany.perfumaria.model;

public class Address {
    long id;
    long clientId;
    String addressName;
    int num;
    String complement;
    String cep;
    String state;
    String city;
    String district;
    
    public long getId() {
        return id;
    }

    public long getClientId() {
        return clientId;
    }

    public String getAddressName() {
        return addressName;
    }

    public int getNum() {
        return num;
    }

    public String getComplement() {
        return complement;
    }

    public String getCep() {
        return cep;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
