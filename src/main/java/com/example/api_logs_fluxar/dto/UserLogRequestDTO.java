package com.example.api_logs_fluxar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Objeto de requisição com dados do log")
public class UserLogRequestDTO {
    @Schema(description = "Id do usuário", example = "1")
    @NotNull(message = "O Id do usuário não pode ser nulo")
    private Long user_id;
    @Schema(description = "Ação registrada no log", example = "login")
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
