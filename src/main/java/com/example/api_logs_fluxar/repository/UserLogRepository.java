package com.example.api_logs_fluxar.repository;

import com.example.api_logs_fluxar.model.UserLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserLogRepository extends MongoRepository<UserLog, String> {
    @Query("{ 'user_id': ?0 }")
    List<UserLog> findByUser_id(Long user_id);

    List<UserLog> findByAction(String action);
}