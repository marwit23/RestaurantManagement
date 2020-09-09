package com.marwit23.cook._exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;
    private List<String> errors;

    public ApiError(HttpStatus status, LocalDateTime timestamp, List<String> errors) {
        super();
        this.status = status;
        this.timestamp = timestamp;
        this.errors = errors;
    }

    public ApiError(HttpStatus status, LocalDateTime timestamp, String error) {
        super();
        this.status = status;
        this.timestamp = timestamp;
        errors = Arrays.asList(error);
    }
}
