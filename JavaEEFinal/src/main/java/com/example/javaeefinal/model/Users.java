package com.example.javaeefinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@NotNull
@Getter @Setter
// TODO нужно доделать не работает персистенс кажется
//@NamedQueries({
//        @NamedQuery(name = Users.FIND_BY_LOGIN_PASSWORD, query = "SELECT u FROM Users u WHERE u.email = :login AND u.password = :password")
//})
public class Users {
//    public static final String FIND_BY_LOGIN_PASSWORD = "User.findByLoginAndPassword";

    private int id;
    private String firstName;
    private String secondName;
    private String email;
    private String password;
    private int address_id;
    private Address addressByAddressId;
    private String created_at;

    public Users() {

    }



    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Users(int id, String firstName, String secondName, String email, String password, int addressId, String created_at) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.password = password;
        this.address_id = addressId;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate localDate = LocalDate.now();

        @NotNull
        String resDate = localDate.format(formatter);

        this.created_at = resDate;
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
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "secondName")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "address_id", referencedColumnName = "id")
    public Address getAddressByAddressId() {
        return addressByAddressId;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setAddressByAddressId(Address addressByAddressId) {
        this.addressByAddressId = addressByAddressId;
    }
}
