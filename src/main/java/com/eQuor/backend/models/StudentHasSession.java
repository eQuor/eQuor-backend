package com.eQuor.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "\"student_has_session\"")
public class StudentHasSession {

    @EmbeddedId
    StudentHasSessionPKey pkey;

    @Column(name = "is_joined")
    Boolean is_joined;


}
