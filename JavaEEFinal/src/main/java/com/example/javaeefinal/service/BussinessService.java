package com.example.javaeefinal.service;

import com.example.javaeefinal.model.News;
import com.example.javaeefinal.repository.Business;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
public class BussinessService {
    @EJB
    private Business repository;

    public List<News> getNews() {
        return repository.getNews();
    }

    public Response updateNews(String param, String value, int id) {
        return repository.updateNews(param, value, id);
    }

    public Response deleteNews(int id) {
        return repository.deleteNews(id);
    }
}
