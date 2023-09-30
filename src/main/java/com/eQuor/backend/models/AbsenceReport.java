package com.eQuor.backend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "\"absence_report\"")

public class AbsenceReport {
    @Id
    @Column(name = "report_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonInclude(JsonInclude.Include.ALWAYS)
    Integer report_id;

    @Column(name = "date")
    String from;

    @Column(name = "module_name")
    String name;

    @Column(name = "reviewed_id")
    String reviewed_id;

    @Column(name = "submitted_student")
    String submitted_student;

}
