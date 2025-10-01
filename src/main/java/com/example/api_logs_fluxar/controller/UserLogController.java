package com.example.api_logs_fluxar.controller;

import com.example.api_logs_fluxar.dto.UserLogRequestDTO;
import com.example.api_logs_fluxar.dto.UserLogResponseDTO;
import com.example.api_logs_fluxar.model.UserLog;
import com.example.api_logs_fluxar.repository.UserLogRepository;
import com.example.api_logs_fluxar.service.UserLogService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
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
    public List<UserLogResponseDTO> findUserLogs() {
        return userLogService.getAllLogs();
    }

    @GetMapping("/search/by/userId/{userId}")
    public List<UserLogResponseDTO> findUserLogsByUserId(@PathVariable Long user_id) {
        return userLogService.getLogsByUserId(user_id);
    }

    @GetMapping("/search/by/action/{action}")
    public List<UserLogResponseDTO> findUserLogsByAction(@PathVariable String action) {
        return userLogService.getLogsByAction(action);
    }

    @PostMapping("/add")
    public ResponseEntity<UserLogResponseDTO> createUserLog(@RequestBody @Valid UserLogRequestDTO userLog) {
        return ResponseEntity.ok(userLogService.addUserLog(userLog));
    }
}