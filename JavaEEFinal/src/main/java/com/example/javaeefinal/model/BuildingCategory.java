package com.example.javaeefinal.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@NotNull
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        BuildingCategory that = (BuildingCategory) o;
//
//        if (id != that.id) return false;
//        if (buildingId != that.buildingId) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + buildingId;
//        return result;
//    }

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    public Building getBuildingById() {
        return buildingById;
    }

    public void setBuildingById(Building buildingById) {
        this.buildingById = buildingById;
    }
}
