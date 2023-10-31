package com.eQuor.backend.models;

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
@Table(name = "\"student_register_modules\"")
public class St_module {
    @EmbeddedId
    private St_attend id;
}
