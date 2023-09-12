package com.eQuor.backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "\"lecturer\"")
public class Lecturer {
    @Id
    @Column(name = "id")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    String id;
    @Column(name = "name")
    String name;
    @Column(name = "email")
    String email;
    @Column(name = "password")
    String password;

    @Column(name = "user_name")
    String user_name;
    @Column(name = "address")
    String address;


    @Column(name = "managed_staff")
    Integer managedStaff;

}
