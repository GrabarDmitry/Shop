package com.shop.portfolio.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Setter
@Getter
@AllArgsConstructor
public class ValidateExceptionInfo {
    private String HttpStatusCode;
    private Map<String, List<String>> message;
}


