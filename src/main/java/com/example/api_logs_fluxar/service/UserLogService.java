package com.example.api_logs_fluxar.service;

import com.example.api_logs_fluxar.dto.UserLogRequestDTO;
import com.example.api_logs_fluxar.dto.UserLogResponseDTO;
import com.example.api_logs_fluxar.exception.UserLogNotFoundException;
import com.example.api_logs_fluxar.model.UserLog;
import com.example.api_logs_fluxar.repository.UserLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserLogService {
    private final UserLogRepository userLogRepository;
    private final ObjectMapper objectMapper;

    public UserLogService(UserLogRepository userLogRepository, ObjectMapper objectMapper) {
        this.userLogRepository = userLogRepository;
        this.objectMapper = objectMapper;
    }

    public List<UserLogResponseDTO> getAllLogs() {
        List<UserLog> userLogs = userLogRepository.findAll();
        List<UserLogResponseDTO> response = new ArrayList<>();

        for (UserLog userLog : userLogs) {
            response.add(objectMapper.convertValue(userLog, UserLogResponseDTO.class));
        }
        return response;
    }

    public List<UserLogResponseDTO> getLogsByUserId(Long user_id) {
        List<UserLog> userLogs = userLogRepository.findByUser_id(user_id);

        if (userLogs.isEmpty()) {
            throw new UserLogNotFoundException("Nenhum log encontrado do usuário com Id " + user_id + ".");
        }

        List<UserLogResponseDTO> response = new ArrayList<>();
        for (UserLog userLog : userLogs) {
            response.add(objectMapper.convertValue(userLog, UserLogResponseDTO.class));
        }
        return response;
    }

    public List<UserLogResponseDTO> getLogsByAction(String action) {
        List<UserLog> userLogs = userLogRepository.findByAction(action);

        if (userLogs.isEmpty()) {
            throw new UserLogNotFoundException("Nenhum log encontrado da ação " + action + ".");
        }

        List<UserLogResponseDTO> response = new ArrayList<>();
        for (UserLog userLog : userLogs) {
            response.add(objectMapper.convertValue(userLog, UserLogResponseDTO.class));
        }
        return response;
    }

    public List<UserLogResponseDTO> getLogsByDoneAt(LocalDate date) {
        List<UserLog> userLogs = userLogRepository.findByDone_at(date);

        if (userLogs.isEmpty()) {
            throw new UserLogNotFoundException("Nenhum log encontrado na data " + date + ".");
        }

        List<UserLogResponseDTO> response = new ArrayList<>();
        for (UserLog userLog : userLogs) {
            response.add(objectMapper.convertValue(userLog, UserLogResponseDTO.class));
        }
        return response;
    }

    public UserLogResponseDTO addUserLog(UserLogRequestDTO userLogRequestDTO) {
        UserLog userLogModel = objectMapper.convertValue(userLogRequestDTO, UserLog.class);
        userLogModel.setDone_at(LocalDate.now());

        return objectMapper.convertValue(userLogRepository.save(userLogModel), UserLogResponseDTO.class);
    }
}
