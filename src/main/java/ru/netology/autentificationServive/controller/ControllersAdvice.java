package ru.netology.autentificationServive.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.netology.autentificationServive.exeption.InvalidCredentials;
import ru.netology.autentificationServive.exeption.UnauthorizedUser;

@RestControllerAdvice
public class ControllersAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleRE (InvalidCredentials ex) {
        return new ResponseEntity<>("Got an exception: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleRE (UnauthorizedUser ex) {
        System.out.println("Got an exception: " + ex.getMessage());
        return new ResponseEntity<>("Got an exception: " + ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
