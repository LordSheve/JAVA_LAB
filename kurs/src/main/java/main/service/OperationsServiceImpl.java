package main.service;

import main.entity.Balance;
import main.entity.Operations;
import main.exeption.BalanceNotFoundExeption;
import main.exeption.OperationsNotFoundExeption;
import main.repository.BalanceRepository;
import main.repository.OperationsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationsServiceImpl implements OperationsService {

    @Autowired
    private OperationsRepository operationsRepository;

    @Override
    public List<Operations> listOperations() {
        return (List<Operations>) operationsRepository.findAll();
    }

    @Override
    public Operations findOperations(long id) {
        Optional<Operations> optionalOperations = operationsRepository.findById(id);
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
    public Operations updateOperations(long id, Operations operations) {
        Operations existingOperations = findOperations(id);
        BeanUtils.copyProperties(operations, existingOperations);
        return operationsRepository.save(existingOperations);
    }

    @Override
    public void deleteOperations(long id) {
        operationsRepository.delete(findOperations(id));
    }
}
