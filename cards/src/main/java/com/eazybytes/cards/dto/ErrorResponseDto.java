package com.eazybytes.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold Error Response Information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API Path invoked by Client"
    )
    private String apiPath;

    @Schema(
            description = "Error Code representing the error occurred"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error Message representing error occurred"
    )
    private String errorMessage;

    @Schema(
            description = "Time representing when the Error occurred"
    )
    private LocalDateTime errorTime;
}
