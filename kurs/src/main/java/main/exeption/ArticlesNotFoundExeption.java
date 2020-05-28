package main.exeption;

public class ArticlesNotFoundExeption extends RuntimeException {
    public ArticlesNotFoundExeption(String message) {
        super(message);
    }
}
