package online.noithat.be.dto;

import lombok.Data;
import online.noithat.be.enums.Role;

@Data
public class RegisterRequestDTO {
    String username;
    String password;
    String email;
    String phone;
    String address;
    Role role;

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
