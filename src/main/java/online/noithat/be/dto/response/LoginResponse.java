package online.noithat.be.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import online.noithat.be.enums.Role;
import online.noithat.be.enums.Status;

@Data
public class LoginResponse {
    long id;
    String username;
    String email;
    String token;
    @Enumerated(EnumType.STRING)
    Role role;

    @Enumerated(EnumType.STRING)
    Status status;

}
