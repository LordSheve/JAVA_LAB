package main.controller;

import lombok.RequiredArgsConstructor;
import main.entity.Articles;
import main.exeption.ArticlesNotFoundExeption;
import main.service.ArticlesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
;
import java.util.List;

@RestController
@RequestMapping("/lib")
@RequiredArgsConstructor
public class ArticlesController {

    private final ArticlesService articlesService;

    @PostMapping(value = "articles/add", consumes = "application/json", produces = "application/json")
    public Articles addArticles(@RequestBody Articles articles)
    {
        System.err.println("art " + articles.getName());
        return articlesService.addArticles(articles);
    }

    @GetMapping("articles/all")
    public ResponseEntity<List<Articles>> getAllArticles() {
        List<Articles> list = articlesService.listArticles();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("articles/{id}")
    public ResponseEntity<Articles> getArticles(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(articlesService.findArticles(id), HttpStatus.OK);
        } catch (ArticlesNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    @DeleteMapping("articles/{id}")
    public void deleteArticles(@PathVariable("id") long id) {
        try {
            articlesService.deleteArticles(id);
        } catch (ArticlesNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    @PutMapping(value = "articles/{id}", consumes = "application/json", produces = "application/json")
    public Articles updateArticles(@PathVariable("id") long id, @RequestBody Articles articles) {
        try {
            return articlesService.updateArticles(id, articles);
        } catch (ArticlesNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!");
        }
    }
}
