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
@Table(name = "\"student_register_modules\"")

public class StudentRegisterModule {


//    @Id
//    @Column(name = "student_id")
//    @JsonInclude(JsonInclude.Include.ALWAYS)
//    String student_id;
//
//    @Column(name = "module_id")
//    Integer module_id;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    String student_id;

    @Column(name = "module_id")
    Integer module_id;

}
