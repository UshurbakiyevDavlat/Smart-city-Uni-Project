package com.example.javaeefinal.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Job {
    private int id;
    private String title;
    private String description;
    private double salary;
    private HumanResources humanResourcesByHrId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (id != job.id) return false;
        if (Double.compare(job.salary, salary) != 0) return false;
        if (!Objects.equals(title, job.title)) return false;
        if (!Objects.equals(description, job.description)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(salary);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "hr_id", referencedColumnName = "id", nullable = false)
    public HumanResources getHumanResourcesByHrId() {
        return humanResourcesByHrId;
    }

    public void setHumanResourcesByHrId(HumanResources humanResourcesByHrId) {
        this.humanResourcesByHrId = humanResourcesByHrId;
    }
}
