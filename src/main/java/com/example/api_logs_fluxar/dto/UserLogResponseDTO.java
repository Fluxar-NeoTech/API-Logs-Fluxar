package com.example.api_logs_fluxar.dto;

import java.time.LocalDate;

public class UserLogResponseDTO {
    private String user_id;
    private String action;
    private LocalDate done_at;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDate getDone_at() {
        return done_at;
    }

    public void setDone_at(LocalDate done_at) {
        this.done_at = done_at;
    }
}
