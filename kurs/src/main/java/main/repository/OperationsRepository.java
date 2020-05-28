package main.repository;

import main.entity.Operations;
import org.springframework.data.repository.CrudRepository;

public interface OperationsRepository extends CrudRepository<Operations, Long> {
}
