package main.controller;

import main.entity.Operations;
import main.exeption.OperationsNotFoundExeption;
import main.service.OperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("operations")
public class OperationsController {
    private OperationsService operationsService;

    public OperationsController(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @PostMapping(value = "/add", consumes = "operations/json", produces = "operations/json")
    public Operations addOperations(@RequestBody Operations operations) {
        return operationsService.addOperations(operations);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Operations>> getAllOperations() {
        List<Operations> list = operationsService.listOperations();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operations> getOperations(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(operationsService.findOperations(id), HttpStatus.OK);
        } catch (OperationsNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOperations(@PathVariable("id") Long id) {
        try {
            operationsService.deleteOperations(id);
        } catch (OperationsNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    @Autowired
    public void setOperationsService(OperationsService operationsService) {
        this.operationsService = operationsService;
    }
}
