package com.personal.productcatalog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResumeController {

    @GetMapping("/resume")
    public String resume() {
        return "Working...";
    }
}
