package br.com.eHealth.exception;

public class ValidationException extends RuntimeException {

    public ValidationException() {
        super("Erro de validação.");
    }
    public ValidationException(String message) {
        super(message);
    }
}
