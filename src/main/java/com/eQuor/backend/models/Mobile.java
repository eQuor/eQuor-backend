package com.eQuor.backend.models;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter

@Setter
@Table(name = "\"mobile\"")
public class Mobile {
    @Id
    @Column(name = "id")
    String id;

    @Column(name = "device_name")
    String device_name;

    @Column(name = "os")
    String os;



}
