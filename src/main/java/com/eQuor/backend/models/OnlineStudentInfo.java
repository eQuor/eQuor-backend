package com.eQuor.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Entity
public class OnlineStudentInfo {
    @Id
    String student_id;
//    Integer session_id;
    String student_name;
    String student_email;
    Boolean is_joined;
}
