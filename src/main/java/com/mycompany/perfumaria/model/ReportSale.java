package com.mycompany.perfumaria.model;

public class ReportSale {
    long id;
    String status;
    double total;
    String cpf;

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
