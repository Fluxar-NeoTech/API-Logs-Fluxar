package com.example.api_logs_fluxar.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserLogRequestDTO {
    @NotNull(message = "O Id do usuário não pode ser nulo")
    private Long user_id;
    @NotNull(message = "A ação não pode ser nula")
    @NotBlank(message = "A ação precisa ser informada")
    private String action;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
