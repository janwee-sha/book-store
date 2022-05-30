package com.janwee.bookstore.resource;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
public class Result {
    private LocalDateTime timestamp;
    private HttpStatus status;
    private String error;
    private String message;
    private String detail;
    private String path;

    public Result() {
        this.timestamp = LocalDateTime.now();
    }

    public Result ofStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public Result ofError(String error) {
        this.error = error;
        return this;
    }

    public Result ofMessage(String message) {
        this.message = message;
        return this;
    }

    public Result ofDetail(String detail) {
        this.detail = detail;
        return this;
    }

    public Result ofPath(String path) {
        this.path = path;
        return this;
    }

    public Integer getStatus() {
        return Optional.ofNullable(status).map(HttpStatus::value).orElse(null);
    }
}