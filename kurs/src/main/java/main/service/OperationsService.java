package main.service;

import main.entity.Operations;

import java.util.List;

public interface OperationsService {
    List<Operations> operationlList();
    Operations findOperations(int id);
    Operations addOperations(Operations operations);
    void deleteOperations(int id);
}
