package main.service;

import main.entity.Balance;

import java.util.List;

public interface BalanceService {
    List<Balance> balanceList();
    Balance findBalance(int id);
    Balance addBalance(Balance balance);
    void deleteBalance(int id);
}
