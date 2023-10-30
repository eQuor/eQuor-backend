package com.eQuor.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter

@Setter
@Table(name = "\"student_attend_session\"")
public class Student_attend_session {

   @EmbeddedId
    private St_attend id;



}
