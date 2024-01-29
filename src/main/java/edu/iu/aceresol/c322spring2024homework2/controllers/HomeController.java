package edu.iu.aceresol.c322spring2024homework2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String greetings(){
        return "welcome";
    }
}
