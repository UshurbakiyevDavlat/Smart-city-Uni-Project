package com.example.javaeefinal.service;

import com.example.javaeefinal.model.Address;
import com.example.javaeefinal.repository.Tourism;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class TourismService {
    @EJB
    Tourism repository;

    public List<Address> getAddresses() {
        return repository.getAddresses();

    }


    public Response updateAddress(String param, String value, int id) {
        return repository.updateAddress(param, value, id);
    }

    public Response deleteAddress(int id) {
        return repository.deleteAddress(id);
    }
}
