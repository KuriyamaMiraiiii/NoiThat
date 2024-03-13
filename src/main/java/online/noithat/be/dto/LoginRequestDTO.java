package online.noithat.be.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    String username;
    String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
