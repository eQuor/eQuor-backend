package com.eQuor.backend.dto;

import com.eQuor.backend.models.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {
    String username;
    String jwtToken;
    Boolean isAuth;

    private Collection<? extends GrantedAuthority> role;

}
