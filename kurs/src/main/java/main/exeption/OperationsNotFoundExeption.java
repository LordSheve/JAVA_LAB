package main.exeption;

public class OperationsNotFoundExeption extends RuntimeException {
    public  OperationsNotFoundExeption(String message) {
        super(message);
    }
}
