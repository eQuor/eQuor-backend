package com.eQuor.backend.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.configurationprocessor.json.JSONArray;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "\"session\"")
public class Sessions {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "requirement")
    Integer requirement;
    @Column(name = "start_time")
    String start_time;
    @Column(name = "end_time")
    String end_time;
    @Column(name = "session_name")
    String session_name;
    @Column(name = "module_id")
    Integer module_id;

    @Column(name = "qr_code")
    String qr_code;
}
