package com.example.javaeefinal.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

@Entity
@NotNull
public class Address {
    private int id;
    private String city;
    private String streetName;
    private String streetNumber;
    private String created_at;

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "streetName")
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Basic
    @Column(name = "streetNumber")
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Address(int id, String city, String streetName, String streetNumber, String created_at) {
        this.id = id;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate localDate = LocalDate.now();

        @NotNull
        String resDate = localDate.format(formatter);

        this.created_at = resDate;
    }

    public Address() {
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Address address = (Address) o;
//
//        if (id != address.id) return false;
//        if (!Objects.equals(city, address.city)) return false;
//        if (!Objects.equals(streetName, address.streetName)) return false;
//        return Objects.equals(streetNumber, address.streetNumber);
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (city != null ? city.hashCode() : 0);
//        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
//        result = 31 * result + (streetNumber != null ? streetNumber.hashCode() : 0);
//        return result;
//    }
}
