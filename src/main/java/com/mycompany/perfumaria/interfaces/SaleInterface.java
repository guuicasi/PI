package com.mycompany.perfumaria.interfaces;

import com.mycompany.perfumaria.model.Sale;

public interface SaleInterface {
    public void delete(long id);
    public void insert(Sale sale);
    public Sale update(Sale sale);
    public Sale get(long id);
    public Sale getLastSaleByClientId(long clientIdß);
}
