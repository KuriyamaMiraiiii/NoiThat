package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Account;

import online.noithat.be.dto.LoginRequestDTO;
import online.noithat.be.dto.RegisterRequestDTO;
import online.noithat.be.dto.request.LoginGoogleDTO;
import online.noithat.be.dto.response.LoginResponse;
import online.noithat.be.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;


    @PostMapping("/authentication/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO registerRequestDTO){
        Account newAccount = authenticationService.register(registerRequestDTO);
        return ResponseEntity.ok(newAccount);
    }
    @PostMapping("/authentication/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO loginRequestDTO){
        LoginResponse newAccount = authenticationService.login(loginRequestDTO);
        return ResponseEntity.ok(newAccount);
    }

    @PostMapping("/authentication/login-gg")
    public ResponseEntity logingg(@RequestBody LoginGoogleDTO loginGoogleDTO){
        LoginResponse  newAccount = authenticationService.logingg(loginGoogleDTO);
        return ResponseEntity.ok(newAccount);
    }

    @GetMapping("/authentication/accounts")
    public ResponseEntity getAllAccount(){
        List<Account> accounts = authenticationService.getAllAccount();
        return ResponseEntity.ok(accounts);
    }

    @PostMapping("/authentication/register-staff")
    public ResponseEntity registerStaff(@RequestBody RegisterRequestDTO registerRequestDTO){
        Account newAccount = authenticationService.registerStaff(registerRequestDTO);
        return ResponseEntity.ok(newAccount);
    }

    @DeleteMapping("/authentication/delete-account/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        return ResponseEntity.ok(authenticationService.delete(id));
    }

    @GetMapping("/authentication/account")
    public ResponseEntity getAccountById(){
        Account accounts = authenticationService.getAccountByToken();
        return ResponseEntity.ok(accounts);
    }
}
