package com.example.api_logs_fluxar.controller;

import com.example.api_logs_fluxar.model.UserLog;
import com.example.api_logs_fluxar.repository.UserLogRepository;
import com.example.api_logs_fluxar.service.UserLogService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/userlogs")
public class UserLogController {
    UserLogRepository userLogRepository;
    UserLogService userLogService;

    public UserLogController(UserLogRepository userLogRepository, UserLogService userLogService) {
        this.userLogRepository = userLogRepository;
        this.userLogService = userLogService;
    }

    @GetMapping("/search")
    public List<UserLog> findUserLogs() {
        return userLogService.getAllLogs();
    }

    @PostMapping("/create")
    public ResponseEntity<UserLog> createUserLog(@RequestBody @Validated UserLog userLog) {
        return ResponseEntity.ok(userLogService.createUserLog(userLog));
    }
}