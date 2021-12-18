package com.example.javaeefinal.repositoryImpl;

import com.example.javaeefinal.dbmanager.DBManager;
import com.example.javaeefinal.model.Address;
import com.example.javaeefinal.repository.AddressRepository;

import javax.ejb.EJB;
import java.util.ArrayList;
import java.util.List;

public class AddressRepositoryImpl implements AddressRepository {

    List<Address> addresses = DBManager.getAddresses();

    @Override
    public List<Address> getAllAdressess() {
        return addresses;
    }
}
