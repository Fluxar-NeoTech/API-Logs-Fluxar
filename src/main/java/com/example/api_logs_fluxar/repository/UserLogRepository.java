package com.example.api_logs_fluxar.repository;

import com.example.api_logs_fluxar.model.UserLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserLogRepository extends MongoRepository<UserLog, String> {
}