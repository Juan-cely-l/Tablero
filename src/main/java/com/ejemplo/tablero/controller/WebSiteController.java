package com.ejemplo.tablero.controller;

import com.ejemplo.tablero.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;

@SpringBootApplication
@RestController
public class WebSiteController {

    @Resource
    private HttpServletRequest request;

    public static void main(String[] args) {
        SpringApplication.run(WebSiteController.class, args);
    }

    @GetMapping("/status")
    public String status() {
        sessionManagement();
        String name = (String) request.getSession().getAttribute("name");
        return "{\"status\":\"Greetings from Spring Boot "
                + name + ". "
                + java.time.LocalDate.now() + ", "
                + java.time.LocalTime.now()
                + ". " + "The server is Running!\"}";
    }

    @GetMapping("/index/color/r")
    public ResponseEntity<String> colorChange() {
        sessionManagement();
        return new ResponseEntity<>(User.getInstance().colorPos(request.getSession(true).getId()), HttpStatus.OK);
    }

    public void sessionManagement() {
        User.getInstance().setUserInstance(request.getSession(true).getId());
        System.out.println(request.getSession(true).getId());
        System.out.println("Numero de usuarios:" + User.getInstance().getUsers().size());
    }
}
