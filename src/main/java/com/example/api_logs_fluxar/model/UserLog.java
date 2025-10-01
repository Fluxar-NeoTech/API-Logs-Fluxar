package com.example.api_logs_fluxar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "logs")
public class UserLog {

    @Id
    private String id;
    private Long user_id;
    private String action;
    private Date done_at;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public Long getUser_id() { return user_id; }
    public void setUser_id(Long user_id) { this.user_id = user_id; }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDone_at() { return done_at; }
    public void setDone_at(Date done_at) { this.done_at = done_at; }
}