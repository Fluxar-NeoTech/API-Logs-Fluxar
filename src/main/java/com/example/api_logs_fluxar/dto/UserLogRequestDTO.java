package com.example.api_logs_fluxar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class UserLogRequestDTO {
    @NotNull(message = "O Id do usuário não pode ser nulo")
    @NotBlank(message = "O Id do usuário precisa ser informado")
    private String userId;
    @NotNull(message = "A ação não pode ser nula")
    @NotBlank(message = "A ação precisa ser informada")
    private String action;
    private Date done_at;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDone_at() {
        return done_at;
    }

    public void setDone_at(Date done_at) {
        this.done_at = done_at;
    }
}
