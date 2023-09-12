package com.eQuor.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "\"api_request\"")
public class APIRequest {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name="email")
    String email;
    @Column(name="action")
    String action;
    @Column(name="full_name")
    String full_name;

    @Column(name="status")
    String status;
    @Column(name="address")
    String address;
    @Column(name="managed_admin")
    Integer managed_admin;
}
