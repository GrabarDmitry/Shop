package com.shop.portfolio.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"Security"})
@RestController
public class SecurityController {

    @ApiOperation(value = "Say hello")
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(
                "Hello World:)"
        );
    }


}
