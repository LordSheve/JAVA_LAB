package main.controller;

import main.entity.Balance;
import main.exeption.BalanceNotFoundExeption;
import main.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private BalanceService balanceService;

    @PostMapping(value = "/add", consumes = "balances/json", produces = "balances/json")
    public Balance addBalance(@RequestBody Balance balance) {
        return balanceService.addBalance(balance);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Balance>> getAllBalance() {
        List<Balance> list = balanceService.listBalance();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Balance> getBalance(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(balanceService.findBalance(id), HttpStatus.OK);
        } catch (BalanceNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!");
        }
    }

    @Autowired
    public void setBalanceService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }
}
