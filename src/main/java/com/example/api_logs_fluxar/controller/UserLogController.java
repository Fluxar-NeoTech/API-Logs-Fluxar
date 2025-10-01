package com.example.api_logs_fluxar.controller;

import com.example.api_logs_fluxar.dto.UserLogRequestDTO;
import com.example.api_logs_fluxar.dto.UserLogResponseDTO;
import com.example.api_logs_fluxar.repository.UserLogRepository;
import com.example.api_logs_fluxar.service.UserLogService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/search/by/userId/{user_id}")
    public List<UserLogResponseDTO> findUserLogsByUserId(@PathVariable Long user_id) {
        return userLogService.getLogsByUserId(user_id);
    }

    @GetMapping("/search/by/action/{action}")
    public List<UserLogResponseDTO> findUserLogsByAction(@PathVariable String action) {
        return userLogService.getLogsByAction(action);
    }

    @GetMapping("/search/by/done_at/{date}")
    public List<UserLogResponseDTO> findUserLogsByDoneAt(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return userLogService.getLogsByDoneAt(date);
    }

    @PostMapping("/add")
    public ResponseEntity<UserLogResponseDTO> createUserLog(@RequestBody @Valid UserLogRequestDTO userLog) {
        return ResponseEntity.ok(userLogService.addUserLog(userLog));
    }
}