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
public class BuildingCategory {
    private int id;
    private int buildingId;
    private Building buildingById;
    private String created_at;

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public BuildingCategory(int id, int buildingId, String created_at) {
        this.id = id;
        this.buildingId = buildingId;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate localDate = LocalDate.now();

        @NotNull
        String resDate = localDate.format(formatter);

        this.created_at = resDate;
    }

    public BuildingCategory() {

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
    @Column(name = "building_id")
    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }


    @OneToOne
    @PrimaryKeyJoinColumn(name = "building_id", referencedColumnName = "id")
    public Building getBuildingById() {
        return buildingById;
    }

    public void setBuildingById(Building buildingById) {
        this.buildingById = buildingById;
    }
}
