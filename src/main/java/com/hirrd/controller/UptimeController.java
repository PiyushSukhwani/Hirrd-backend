package com.hirrd.controller;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/health")
public class UptimeController {

    @GetMapping
    public String healthCheck() {
        return "App is running!";
    }
}
