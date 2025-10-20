package com.example.api_logs_fluxar.openapi;

import com.example.api_logs_fluxar.dto.UserLogRequestDTO;
import com.example.api_logs_fluxar.dto.UserLogResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;

public interface UserLogOpenAPI {
    @Operation(summary = "Busca todos os logs de ações de usuários", description = "Retorna todos os logs registrados")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Logs encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserLogRequestDTO.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Nenhum log encontrado")
    })
    List<UserLogResponseDTO> findUserLogs();
    @Operation(summary = "Busca logs pelo Id do usuário", description = "Retorna logs do usuário especificado")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Logs encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserLogRequestDTO.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Nenhum log encontrado")
    })
    List<UserLogResponseDTO> findUserLogsByUserId(@PathVariable Long user_id);

    @Operation(summary = "Busca logs pela ação realizada", description = "Retorna logs filtrados pela ação especificada")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Logs encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserLogRequestDTO.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Nenhum log encontrado")
    })
    List<UserLogResponseDTO> findUserLogsByAction(@PathVariable String action);

    @Operation(summary = "Busca logs pela data da ação", description = "Retorna logs filtrados pela data especificada")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Logs encontrados",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserLogRequestDTO.class)
                    )),
            @ApiResponse(responseCode = "404", description = "Nenhum log encontrado")
    })
    List<UserLogResponseDTO> findUserLogsByDoneAt(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @Operation(summary = "Adiciona um novo log de ação de usuário", description = "Registra um novo log com os detalhes fornecidos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Log criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserLogRequestDTO.class)
                    )),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    ResponseEntity<UserLogResponseDTO> createUserLog(@RequestBody @Valid UserLogRequestDTO userLog);
    }
