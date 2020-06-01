package main.controller;

import lombok.RequiredArgsConstructor;
import main.entity.Balance;
import main.exeption.BalanceNotFoundExeption;
import main.service.BalanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/lib")
@RequiredArgsConstructor
public class BalanceController {
    private BalanceService balanceService;

    @PostMapping(value = "balance/add", consumes = "balances/json", produces = "balances/json")
    public Balance addBalance(@RequestBody Balance balance) {
        return balanceService.addBalance(balance);
    }

    @GetMapping("balance/all")
    public ResponseEntity<List<Balance>> getAllBalance() {
        List<Balance> list = balanceService.listBalance();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("balance/{id}")
    public ResponseEntity<Balance> getBalance(@PathVariable("id") long id) {
        try {
            return new ResponseEntity<>(balanceService.findBalance(id), HttpStatus.OK);
        } catch (BalanceNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!");
        }
    }

    @DeleteMapping("balance/{id}")
    public void deleteBalance(@PathVariable("id") long id) {
        try {
            balanceService.deleteBalance(id);
        } catch (BalanceNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }

    @PutMapping(value = "balance/{id}", consumes = "application/json", produces = "application/json")
    public Balance updateBalance(@PathVariable("id") long id, @RequestBody Balance balance) {
        try {
            return balanceService.updateBalance(id, balance);
        } catch (BalanceNotFoundExeption exeption) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found!");
        }
    }
}
