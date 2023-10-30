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
@Table(name = "\"lecturer_register_module\"")

public class LecturerRegisterModule {


    @Id
    @Column(name = "lecturer_id")
    @JsonInclude(JsonInclude.Include.ALWAYS)
    String lecturer_id;

    @Column(name = "module_id")
    Integer module_id;

    public String getId() {
        return lecturer_id;
    }
}
