package com.example.vacancy.controllers;

import com.example.vacancy.dto.PersonDTO;
import com.example.vacancy.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/getPerson")
    public PersonDTO getPerson(@RequestParam long id) {
        return Optional.ofNullable(
                mainService.getPersonFromDb(id)).
                orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND));
    }
}
