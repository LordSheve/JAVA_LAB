package main.controller;

import lombok.RequiredArgsConstructor;
import main.entity.Operations;
import main.exeption.OperationsNotFoundExeption;
import main.service.OperationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("lib")
@RequiredArgsConstructor
public class OperationsController {
    private final OperationsService operationsService;

    @PostMapping(value = "operations/add", consumes = "application/json", produces = "application/json")
    public Operations addOperations(@RequestBody Operations operations) {
        return operationsService.addOperations(operations);
    }

    @GetMapping("operations/all")
    public ResponseEntity<List<Operations>> getAllOperations() {
        List<Operations> list = operationsService.listOperations();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("operations/{id}")
    public ResponseEntity<Operations> getOperations(@PathVariable("id") long id) throws ResponseStatusException {
        try {
            return new ResponseEntity<>(operationsService.findOperations(id), HttpStatus.OK);
        } catch (OperationsNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    @DeleteMapping("operations/{id}")
    public void deleteOperations(@PathVariable("id") long id) {
        try {
            operationsService.deleteOperations(id);
        } catch (OperationsNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    @PutMapping(value = "operations/{id}", consumes = "application/json", produces = "application/json")
    public Operations updateOperations(@PathVariable("id") long id, @RequestBody Operations operations) {
        try {
            return operationsService.updateOperations(id, operations);
        } catch (OperationsNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!");
        }
    }
}
