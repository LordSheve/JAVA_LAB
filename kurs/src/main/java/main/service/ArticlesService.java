package main.service;

import main.entity.Articles;

import java.util.List;

public interface ArticlesService {
    List<Articles> articlesList();
    Articles findArticles(int id);
    Articles addArticles(Articles articles);
    void deleteArticles(int id);
}
