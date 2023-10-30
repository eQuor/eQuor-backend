package com.eQuor.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable
public class StudentModule implements Serializable {

    @Column(name = "student_id")
    String student_id;
    @Column(name = "module_id")
    String module_id;
}
