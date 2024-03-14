package online.noithat.be.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import online.noithat.be.enums.Role;
import online.noithat.be.enums.Status;

@Data
public class RegisterRequestDTO {
    String username;
    String password;
    String email;
    String phone;
    String address;
    @Enumerated(EnumType.STRING)
    Status status;
    @Enumerated(EnumType.STRING)
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
