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
public class Job {
    private int id;
    private String title;
    private String description;
    private double salary;
    private int hr_id;
    private HumanResources humanResourcesByHrId;
    private String created_at;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public Job() {

    }

    public int getHr_id() {
        return hr_id;
    }

    public void setHr_id(int hr_id) {
        this.hr_id = hr_id;
    }

    public Job (int id, String title, String description, double salary, int hr_id, String created_at) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.hr_id = hr_id;
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

    @Basic
    @Column(name = "salary")
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    @ManyToOne
    @PrimaryKeyJoinColumn(name = "hr_id", referencedColumnName = "id")
    public HumanResources getHumanResourcesByHrId() {
        return humanResourcesByHrId;
    }

    public void setHumanResourcesByHrId(HumanResources humanResourcesByHrId) {
        this.humanResourcesByHrId = humanResourcesByHrId;
    }
}
