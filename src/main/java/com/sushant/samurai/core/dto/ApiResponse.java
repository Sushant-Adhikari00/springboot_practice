package com.sushant.samurai.core.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ApiResponse {
    private boolean success;
    private String message;
    private Integer statusCode;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:s a")
    private LocalDateTime timestamp;
}
