package main.service;

import main.entity.Operations;

import java.util.List;

public interface OperationsService {
    List<Operations> listOperations();

    Operations findOperations(long id);
    Operations addOperations(Operations operations);
    Operations updateOperations(long id, Operations operations);
    void deleteOperations(long id);
}
