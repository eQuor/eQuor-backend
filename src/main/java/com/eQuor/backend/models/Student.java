package com.eQuor.backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Random;

@Entity
//@NoArgsConstructor
//@AllArgsConstructor
@Data
@Getter

@Setter
@Table(name = "\"student\"")
public class Student {
    @Id
    @Column(name = "id")
    String id;


    @Column(name = "name")
    String name;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;

    @Column(name = "user_name")
    String username;
    @Column(name = "address")
    String address;


    @Column(name = "managed_staff")
    String managedStaff;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;



    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @PrePersist
    public void prePersist() {
        this.managedStaff = "2021STF021";
    }

}
