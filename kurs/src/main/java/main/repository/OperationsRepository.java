package main.repository;

import main.entity.Operations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationsRepository extends CrudRepository<Operations, Long> {
}
