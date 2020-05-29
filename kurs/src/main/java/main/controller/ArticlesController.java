package main.controller;


import main.entity.Articles;
import main.exeption.ArticlesNotFoundExeption;
import main.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticlesController {
    private ArticlesService articlesService;

    @GetMapping("/all")
    public ResponseEntity<List<Articles>> getAllArticles() {
        List<Articles> list = articlesService.listArticles();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Articles> getArticles(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(articlesService.findArticles(id), HttpStatus.OK);
        } catch (ArticlesNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    @Autowired
    private void setArticlesService(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }
}
