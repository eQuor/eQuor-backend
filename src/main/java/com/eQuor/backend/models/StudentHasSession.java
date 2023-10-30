package com.eQuor.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "\"student_has_session\"")
public class StudentHasSession {

    String student_id;
    Integer session_id;
}
