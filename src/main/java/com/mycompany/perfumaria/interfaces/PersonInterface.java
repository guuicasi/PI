package com.mycompany.perfumaria.interfaces;

import com.mycompany.perfumaria.model.Person;

public interface PersonInterface {
    public void delete(long id);
    public void insert(Person person);
    public Person update(Person person);
    public Person getByCpf(String cpf);
    public Person login(String email, String password, String personType);
} 
