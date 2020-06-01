package main.exeption;

public class InvalidJwtAuthenticationException extends RuntimeException {
    public InvalidJwtAuthenticationException(String msg) {
        super(msg);
    }
}
