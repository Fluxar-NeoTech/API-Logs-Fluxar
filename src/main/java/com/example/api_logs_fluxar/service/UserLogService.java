package com.example.api_logs_fluxar.service;

import com.example.api_logs_fluxar.model.UserLog;
import com.example.api_logs_fluxar.repository.UserLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLogService {
    private final UserLogRepository userLogRepository;

    public UserLogService(UserLogRepository userLogRepository) {
        this.userLogRepository = userLogRepository;
    }

    public List<UserLog> getAllLogs() {
        return userLogRepository.findAll();
    }

    public UserLog createUserLog(UserLog userLog) {
        return userLogRepository.save(userLog);
    }
}
