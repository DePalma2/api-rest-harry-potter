package com.apiharrypotter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(name = "/api/v1")
public class HomeController {

    @GetMapping(name = "/")
    public void welcomeHome(HttpServletResponse response) throws IOException {
       response.sendRedirect("/home");
    }

    @GetMapping("/home")
    public String welcomeHome() {
        return "Welcome to the Harry Potter API";
    }


}
