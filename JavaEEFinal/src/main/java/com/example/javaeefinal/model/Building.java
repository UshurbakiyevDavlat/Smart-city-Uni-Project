package com.example.javaeefinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@NotNull
@Getter @Setter
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


    @ManyToOne
    @PrimaryKeyJoinColumn(name = "address_id", referencedColumnName = "id")

    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
