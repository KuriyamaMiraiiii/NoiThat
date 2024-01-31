package online.noithat.be.service;

import online.noithat.be.Entity.Account;
import online.noithat.be.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    public Account register(Account account){
        String rawPassword = account.getPassword();
        account.setPassword(passwordEncoder.encode(rawPassword));
        // save to database
        return accountRepository.save(account);
    }
    public Account login(Account account){
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(),account.getPassword()));
            Account loginAccount =(Account) authentication.getPrincipal();
            return loginAccount;
            //đăng nhập thành công
        }catch (Exception e){
            return null;
        }
    }

}
