package com.example.api_logs_fluxar.openapi;

import com.example.api_logs_fluxar.dto.UserLogRequestDTO;
import com.example.api_logs_fluxar.dto.UserLogResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;

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
    }
