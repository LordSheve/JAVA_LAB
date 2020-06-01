package main.service;

import main.entity.Articles;

import java.util.List;

public interface ArticlesService {
    List<Articles> listArticles();

    Articles findArticles(long id);
    Articles addArticles(Articles articles);
    Articles updateArticles(long id, Articles articles);
    void deleteArticles(long id);
}
