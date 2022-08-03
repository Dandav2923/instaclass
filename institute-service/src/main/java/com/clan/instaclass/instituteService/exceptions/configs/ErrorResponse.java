package com.clan.instaclass.instituteService.exceptions.configs;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private HttpStatus status;
    private LocalDateTime timestamp;
    private String msg;
    private String debugMsg;

    public ErrorResponse() {
        timestamp = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus status, Throwable e) {
        this();
        this.status = status;
        this.msg = "Unexpected error";
        this.debugMsg = e.getLocalizedMessage();
    }

    public ErrorResponse(HttpStatus status, String msg, Throwable e) {
        this(status, e);
        this.msg = msg;
    }
}
