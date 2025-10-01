package com.example.api_logs_fluxar.exception;

public class UserLogNotFoundException extends RuntimeException {
    public UserLogNotFoundException(String message) {
        super(message);
    }
    public UserLogNotFoundException() {
        super("Nenhum log encontrado.");
    }

}
