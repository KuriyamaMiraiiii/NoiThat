package online.noithat.be.service;

//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.FirebaseToken;
import online.noithat.be.Entity.Account;
import online.noithat.be.dto.LoginRequestDTO;
import online.noithat.be.dto.RegisterRequestDTO;
import online.noithat.be.dto.request.LoginGoogleDTO;
import online.noithat.be.dto.response.LoginResponse;
import online.noithat.be.exception.AccountNotFound;
import online.noithat.be.repository.AccountRepository;
import online.noithat.be.security.TokenHandler;
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

    @Autowired
    TokenHandler tokenHandler;
    public Account register(RegisterRequestDTO registerRequestDTO){
        Account account = new Account();
        account.setEmail(registerRequestDTO.getEmail());
        account.setUsername(registerRequestDTO.getUsername());
        String rawPassword = registerRequestDTO.getPassword();
        account.setPassword(passwordEncoder.encode(rawPassword));
        account.setPhone(registerRequestDTO.getPhone());
        account.setAddress(registerRequestDTO.getAddress());
        account.setRole(registerRequestDTO.getRole());
        // save to database
        return accountRepository.save(account);
    }
    public LoginResponse login(LoginRequestDTO account){
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(account.getUsername(),account.getPassword()));
            Account loginAccount =(Account) authentication.getPrincipal();

            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setId(loginAccount.getId());
            loginResponse.setEmail(loginAccount.getEmail());
            loginResponse.setUsername(loginAccount.getUsername());
            loginResponse.setRole(loginAccount.getRole());
            loginResponse.setToken(tokenHandler.generateToken(loginAccount));

            return loginResponse;
            //đăng nhập thành công
        }catch (Exception e){
            e.printStackTrace();
           throw new AccountNotFound("Account not found");
        }
    }
//    public LoginResponse logingg(LoginGoogleDTO loginGoogleDTO) {
//        try {
//            FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(loginGoogleDTO.getToken());
//            String email = decodedToken.getEmail();
//            Account account = accountRepository.findAccountByEmail(email);
//            if (account == null) {
//                throw new AccountNotFound("Cannot find by email");
//            }
//            LoginResponse loginResponse = new LoginResponse();
//            loginResponse.setId(account.getId());
//            loginResponse.setUsername(account.getUsername());
//            loginResponse.setToken(tokenHandler.generateToken(account));
//            loginResponse.setRole(account.getRole());
//            return loginResponse;
//        } catch (FirebaseAuthException e) {
//            e.printStackTrace();
//            System.out.println(e);
//        }
//        return null;
//    }

}
