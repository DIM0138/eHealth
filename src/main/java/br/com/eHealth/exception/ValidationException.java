package br.com.eHealth.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ValidationException extends RuntimeException {

    private List<String> errors;

    public ValidationException() {
        super("Erro de validação.");
        this.errors = new ArrayList<String>();
    }

    public ValidationException(String message) {
        super(message);
        this.errors = new ArrayList<String>();
    }

    public ValidationException(List<String> errors) {
        super("Erro de validação.");
        this.errors = errors;
    }
    
    public ValidationException(String message, List<String> errors) {
        super("message");
        this.errors = errors;
    }
}
