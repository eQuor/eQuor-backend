package com.eQuor.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Embeddable

public class St_attend implements Serializable {

    @Column(name = "student_id")
    String student_id;
    @Column(name = "session_id")
    Integer session_id;

}
