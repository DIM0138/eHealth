package br.com.eHealth.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UnauthorizedAccessException extends RuntimeException {
    private List<String> errors;

    public UnauthorizedAccessException() {
        super("Acesso não autorizado.");
        this.errors = new ArrayList<String>();
    }

    public UnauthorizedAccessException(String message) {
        super(message);
        this.errors = new ArrayList<String>();
    }

    public UnauthorizedAccessException(List<String> errors) {
        super("Acesso não autorizado.");
        this.errors = errors;
    }
    
    public UnauthorizedAccessException(String message, List<String> errors) {
        super("message");
        this.errors = errors;
    }
}
