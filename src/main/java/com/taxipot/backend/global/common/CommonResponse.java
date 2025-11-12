package com.taxipot.backend.global.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record CommonResponse<T>(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime timestamp,
        String message,
        T result
) {
    public CommonResponse(String message, T result) {
        this(LocalDateTime.now(), message, result);
    }

    public CommonResponse(String message) {
        this(LocalDateTime.now(), message, null);
    }
}
