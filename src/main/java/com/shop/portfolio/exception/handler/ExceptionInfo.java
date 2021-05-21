package com.shop.portfolio.exception.handler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
public class ExceptionInfo {

    private String HttpStatusCode;
    private String message;

    public ExceptionInfo(HttpStatus httpStatus, String message) {
        this.HttpStatusCode = String.valueOf(httpStatus.value());
        this.message = message;
    }

}
