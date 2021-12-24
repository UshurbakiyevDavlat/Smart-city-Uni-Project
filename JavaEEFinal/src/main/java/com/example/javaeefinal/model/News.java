package com.example.javaeefinal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@NotNull
@Getter @Setter
public class News {
    private int id;
    private String title;
    private String description;
    private String created_at;
    private UserNewsInfo news_info;
    public News() {

    }

    public News(int id, String title, String description,String created_at) {
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
}
