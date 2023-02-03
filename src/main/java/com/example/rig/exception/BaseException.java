package com.example.rig.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@Setter
public class BaseException {
    private final String message;
    private final ZonedDateTime timestamp;

    public BaseException(String message, ZonedDateTime timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
