package com.eQuor.backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter

@Setter
@Table(name = "\"lecturer_register_module\"")

public class LecturerRegisterModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lecturer_id")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    String lecturer_id;

    @Column(name = "module_id")
    Integer module_id;


}
