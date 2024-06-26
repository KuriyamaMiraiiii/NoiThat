package online.noithat.be.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import online.noithat.be.enums.Role;
import online.noithat.be.enums.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Account implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String username;
    String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    @Column(unique = true)
    String email;
    String phone;
    String address;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    Status status;

    @Enumerated(EnumType.STRING)
    Role role;


    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
            @JsonIgnore
    List<Request> requests;

    @OneToMany(mappedBy = "staff",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Request> staffRequests;

    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Blog> blogs;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
