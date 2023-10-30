package com.eQuor.backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter

@Setter
@Table(name = "\"student_register_modules\"")

public class StudentRegisterModule {


    @Id
    @Column(name = "student_id")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    String student_id;

    @Column(name = "module_id")
    Integer module_id;

}
