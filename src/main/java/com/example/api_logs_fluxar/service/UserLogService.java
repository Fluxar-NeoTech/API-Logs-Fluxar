package com.example.api_logs_fluxar.service;

import com.example.api_logs_fluxar.dto.UserLogRequestDTO;
import com.example.api_logs_fluxar.dto.UserLogResponseDTO;
import com.example.api_logs_fluxar.exception.UserLogNotFoundException;
import com.example.api_logs_fluxar.model.UserLog;
import com.example.api_logs_fluxar.repository.UserLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserLogService {
    private final UserLogRepository userLogRepository;
    private final ObjectMapper objectMapper;

    public UserLogService(UserLogRepository userLogRepository, ObjectMapper objectMapper ) {
        this.userLogRepository = userLogRepository;
        this.objectMapper = objectMapper;
    }

    public List<UserLogResponseDTO> getAllLogs() {
        List<UserLog> userLogs = userLogRepository.findAll();
        List<UserLogResponseDTO> userLogsResponseDTO = new ArrayList<>();

        for (UserLog userLog : userLogs) {
            userLogsResponseDTO.add(objectMapper.convertValue(userLog, UserLogResponseDTO.class));
        }

        return userLogsResponseDTO;
    }

    public List<UserLogResponseDTO> getLogsByUserId(Long user_id) {
        List<UserLog> userLogs = userLogRepository.findByUser_id(user_id);

        if (userLogs.isEmpty()) {
            throw new UserLogNotFoundException("Nenhum log encontrado do usuário com Id " + user_id + ".");
        }

        List<UserLogResponseDTO> userLogsResponseDTO = new ArrayList<>();

        for (UserLog userLog : userLogs) {
            userLogsResponseDTO.add(objectMapper.convertValue(userLog, UserLogResponseDTO.class));
        }

        return userLogsResponseDTO;
    }

    public List<UserLogResponseDTO> getLogsByAction(String action) {
        List<UserLog> userLogs = userLogRepository.findByAction(action);

        if (userLogs.isEmpty()) {
            throw new UserLogNotFoundException("Nenhum log encontrado da ação " + action + ".");
        }

        List<UserLogResponseDTO> userLogsResponseDTO = new ArrayList<>();

        for (UserLog userLog : userLogs) {
            userLogsResponseDTO.add(objectMapper.convertValue(userLog, UserLogResponseDTO.class));
        }

        return userLogsResponseDTO;
    }

    public UserLogResponseDTO addUserLog(UserLogRequestDTO userLogRequestDTO) {
        UserLog userLogModel = objectMapper.convertValue(userLogRequestDTO, UserLog.class);
        userLogModel.setDone_at(Date.from(Instant.now()));

        return objectMapper.convertValue(userLogRepository.save(userLogModel), UserLogResponseDTO.class);
    }
}
