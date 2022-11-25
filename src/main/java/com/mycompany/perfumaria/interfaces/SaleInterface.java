package com.mycompany.perfumaria.interfaces;

import java.util.List;

import com.google.protobuf.TextFormat.ParseException;
import com.mycompany.perfumaria.model.ReportSale;
import com.mycompany.perfumaria.model.Sale;

public interface SaleInterface {
    public void delete(long id);
    public void insert(Sale sale);
    public Sale update(Sale sale);
    public Sale get(long id);
    public Sale getLastSaleByClientId(long clientIdß);
    public List<ReportSale> getFilterSales(String firstDate, String endDate) throws java.text.ParseException;
}
