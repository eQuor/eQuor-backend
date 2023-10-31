package com.eQuor.backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "\"admin\"")
public class Admin {
    @Id
    @Column(name = "id")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    String id;
    @Column(name = "password")
    String password;

    @Column(name = "user_name")
    String username;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;



    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

}
