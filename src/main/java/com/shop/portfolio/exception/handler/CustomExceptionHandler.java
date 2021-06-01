package com.shop.portfolio.exception.handler;

import com.shop.portfolio.exception.ResourceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({BadCredentialsException.class,ResourceException.class})
    public ResponseEntity<ExceptionInfo> badCredentialsExceptionHandle(Exception ex) {
        log.error("{}: {}", ex.getClass(), ex.getMessage());
        return ResponseEntity
                .badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ExceptionInfo(
                        HttpStatus.BAD_REQUEST,
                        ex.getMessage()));
    }

}
