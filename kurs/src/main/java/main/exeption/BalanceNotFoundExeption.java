package main.exeption;

public class BalanceNotFoundExeption extends RuntimeException {
    public BalanceNotFoundExeption(String message) {
        super(message);
    }
}
