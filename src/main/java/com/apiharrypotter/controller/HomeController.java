package com.apiharrypotter.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping(name = "/api/v1")
@Api(tags = "Welcome Harry Potter API", value = "Home", description = "These are the information and redirection endpointss")
public class HomeController {

    @GetMapping(name = "/")
    public void welcomeHome(HttpServletResponse response) throws IOException {
       response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/home")
    public String welcomeHome() {
        return "Welcome to the Harry Potter API, \n" +
                "The home page is under construction ";
    }


}
