package com.mycompany.perfumaria.interfaces;

import com.mycompany.perfumaria.model.Address;

public interface AddressInterface {
    public void delete(long id);
    public void insert(Address address);
    public Address update(Address address);
    public Address getByClientId(long id);
}
