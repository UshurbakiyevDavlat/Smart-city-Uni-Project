package com.example.javaeefinal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@NotNull
public class Building {
    private int id;
    private BigDecimal rating;
    private String contactNumber;
    private Address addressByAddressId;
    private int address_id;
    private String created_at;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Building(int id, double rating, String contactNumber, int address_id,String created_at) {
        this.id = id;
        this.contactNumber = contactNumber;
        this.address_id = address_id;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate localDate = LocalDate.now();

        @NotNull
        String resDate = localDate.format(formatter);

        @NotNull
        BigDecimal rate = new BigDecimal(rating).setScale(2, RoundingMode.CEILING);

        this.rating = rate;
        this.created_at = resDate;
    }

    public Building() {
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
    @Column(name = "rating")
    public BigDecimal getRating() {
        return rating;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Basic
    @Column(name = "contactNumber")
    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Building building = (Building) o;
//
//        if (id != building.id) return false;
//        if (Double.compare(building.rating, rating) != 0) return false;
//        if (!Objects.equals(contactNumber, building.contactNumber))
//            return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = id;
//        temp = Double.doubleToLongBits(rating);
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (contactNumber != null ? contactNumber.hashCode() : 0);
//        return result;
//    }

    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
