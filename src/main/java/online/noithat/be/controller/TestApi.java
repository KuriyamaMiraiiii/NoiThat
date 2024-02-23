package online.noithat.be.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import online.noithat.be.Entity.Account;
import online.noithat.be.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class TestApi {
    @Autowired
    AccountUtils accountUtils;
    @GetMapping("test")
/*    @PreAuthorize("hasAuthority('Admin')")*/
    public ResponseEntity test(){
        Account account = accountUtils.getCurrentAccount();
        return ResponseEntity.ok(account);
    }
}
