package com.eQuor.backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

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

    @Column(name = "reg_no")
    String reg_no;
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
    @PrePersist
    public void prePersist() {
        this.managedStaff = 1;
    }

}
