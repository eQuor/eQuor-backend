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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    BigInteger id;

    @Column(name = "model_name")
    String model_name;
    @Column(name = "model_number")
    String model_number;
    @Column(name = "imei")
    String imei;


}
