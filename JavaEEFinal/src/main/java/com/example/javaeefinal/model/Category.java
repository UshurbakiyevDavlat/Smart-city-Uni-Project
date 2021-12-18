package com.example.javaeefinal.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Entity
@NotNull
public class Category {
    private int id;
    private String title;
    private String description;
    private String created_at;

    public Category () {

    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Category (int id, String title, String description, String created_at) {
        this.id = id;
        this.title = title;
        this.description = description;
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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Category category = (Category) o;
//
//        if (id != category.id) return false;
//        if (!Objects.equals(title, category.title)) return false;
//        if (!Objects.equals(description, category.description))
//            return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (title != null ? title.hashCode() : 0);
//        result = 31 * result + (description != null ? description.hashCode() : 0);
//        return result;
//    }
}
