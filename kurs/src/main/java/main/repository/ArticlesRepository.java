package main.repository;

import main.entity.Articles;
import org.springframework.data.repository.CrudRepository;

public interface ArticlesRepository extends CrudRepository<Articles, Long> {
}
