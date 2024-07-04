package br.com.eHealth.exception;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResourceNotFoundException extends RuntimeException {

    private List<String> errors;

    public ResourceNotFoundException() {
        super("Recurso não encontrado.");
        this.errors = new ArrayList<String>();
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.errors = new ArrayList<String>();
    }

    public ResourceNotFoundException(List<String> errors) {
        super("Recurso não encontrado.");
        this.errors = errors;
    }
    
    public ResourceNotFoundException(String message, List<String> errors) {
        super("message");
        this.errors = errors;
    }
}
