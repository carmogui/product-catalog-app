package com.personal.productcatalog.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Resume")
@RestController
public class ResumeController {

    @GetMapping("/resume")
    public String resume() {
        return "Working...";
    }
}
