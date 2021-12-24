package com.example.javaeefinal.model;

import javax.persistence.*;
import java.util.List;

@Table(name = "user_news_info")
@Entity
public class UserNewsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "news_id")
    private News news;

//    @ManyToMany(mappedBy = "news_info", cascade = CascadeType.ALL)
//    private List<Users> userses;
//
//    @ManyToMany(mappedBy = "news_info", cascade = CascadeType.ALL)
//    private List<News> newsList;

//    public List<Users> getUserses() {
//        return userses;
//    }
//
//    public void setUserses(List<Users> userses) {
//        this.userses = userses;
//    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}