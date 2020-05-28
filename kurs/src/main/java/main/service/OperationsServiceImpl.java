package main.service;

import main.entity.Balance;
import main.entity.Operations;
import main.exeption.BalanceNotFoundExeption;
import main.exeption.OperationsNotFoundExeption;
import main.repository.BalanceRepository;
import main.repository.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationsServiceImpl implements OperationsService {
    @Autowired
    private OperationsRepository operationsRepository;

    @Override
    public List<Operations> operationlList() {
        return (List<Operations>) operationsRepository.findAll();
    }

    @Override
    public Operations findOperations(int id) {
        Optional<Operations> optionalOperations = operationsRepository.findById((long)id);
        if (optionalOperations.isPresent()) {
            return optionalOperations.get();
        } else {
            throw new OperationsNotFoundExeption("Not found!");
        }
    }

    @Override
    public Operations addOperations(Operations operations) {
        return operationsRepository.save(operations);
    }

    @Override
    public void deleteOperations(int id) {
        Optional<Operations> optionalOperations = operationsRepository.findById((long)id);
        if (optionalOperations.isPresent()) {
            operationsRepository.delete(optionalOperations.get());
        } else {
            throw new OperationsNotFoundExeption("Not found!");
        }
    }
}
