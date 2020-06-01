package main.service;

import main.entity.Articles;
import main.entity.Balance;
import main.exeption.ArticlesNotFoundExeption;
import main.repository.ArticlesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticlesServiceImpl implements ArticlesService {

    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public List<Articles> listArticles() {
        return (List<Articles>) articlesRepository.findAll();
    }

    @Override
    public Articles findArticles(long id) {
        Optional<Articles> optionalArticles = articlesRepository.findById(id);
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
    public Articles updateArticles(long id, Articles articles) {
        Articles existingArticles = findArticles(id);
        BeanUtils.copyProperties(articles, existingArticles);
        return articlesRepository.save(existingArticles);
    }

    @Override
    public void deleteArticles(long id) {
        articlesRepository.delete(findArticles(id));
    }
}
