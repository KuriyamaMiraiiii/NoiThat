package online.noithat.be.controller;

import online.noithat.be.Entity.Account;
import online.noithat.be.dto.LoginRequestDTO;
import online.noithat.be.dto.RegisterRequestDTO;
import online.noithat.be.dto.response.LoginResponse;
import online.noithat.be.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("/authentication/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO account){
        Account newAccount = authenticationService.register(account);
        return ResponseEntity.ok(newAccount);
    }
    @PostMapping("/authentication/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO account){
        LoginResponse newAccount = authenticationService.login(account);
        return ResponseEntity.ok(newAccount);
    }
}
