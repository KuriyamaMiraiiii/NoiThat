package online.noithat.be.utils;

import online.noithat.be.Entity.Account;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AccountUtils {
    public Account getCurrentAccount(){
        return (Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
