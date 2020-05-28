package main.service;

import main.entity.Articles;
import main.exeption.ArticlesNotFoundExeption;
import main.repository.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public List<Articles> articlesList() {
        return (List<Articles>) articlesRepository.findAll();
    }

    @Override
    public Articles findArticles(int id) {
        Optional<Articles> optionalArticles = articlesRepository.findById((long)id);
        if (optionalArticles.isPresent()) {
            return optionalArticles.get();
        } else {
            throw new ArticlesNotFoundExeption("Not found!");
        }
    }

    @Override
    public Articles addArticles(Articles articles) {
        return articlesRepository.save(articles);
    }

    @Override
    public void deleteArticles(int id) {
        Optional<Articles> optionalArticles = articlesRepository.findById((long)id);
        if (optionalArticles.isPresent()) {
            articlesRepository.delete(optionalArticles.get());
        } else {
            throw new ArticlesNotFoundExeption("Not found!");
        }
    }
}
