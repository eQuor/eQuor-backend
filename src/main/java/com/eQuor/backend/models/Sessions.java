package com.eQuor.backend.models;

import jakarta.persistence.*;
import lombok.*;

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
}
