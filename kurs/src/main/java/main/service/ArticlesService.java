package main.service;

import main.entity.Articles;

import java.util.List;

public interface ArticlesService {
    List<Articles> listArticles();
    Articles findArticles(long id);
}
