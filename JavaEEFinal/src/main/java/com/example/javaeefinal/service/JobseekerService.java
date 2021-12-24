package com.example.javaeefinal.service;

import com.example.javaeefinal.model.VacancyCategory;
import com.example.javaeefinal.model.HR;
import com.example.javaeefinal.model.Vacancy;
import com.example.javaeefinal.repository.Jobseekers;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class JobseekerService {
    @EJB
    Jobseekers repository;

    public List<VacancyCategory> getCategory() {
        return repository.getCategory();
    }

    public List<HR> getHumanResources() {
        return repository.getHumanResources();
    }

    public List<Vacancy> getJob() {
        return repository.getJob();
    }

    public Response updateCategory(String param, String value, int id) {
        return repository.updateCategory(param, value, id);
    }

    public Response updateHR(String param, String value, int id) {
        return repository.updateHumanResources(param, value, id);
    }

    public Response updateJob(String param, String value, int id) {
        return repository.updateJob(param, value, id);
    }

    public Response deleteHR(int id) {
        return repository.deleteHumanResources(id);
    }

    public Response deleteJob(int id) {
        return repository.deleteJob(id);
    }
}
