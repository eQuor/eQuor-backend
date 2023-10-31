package com.eQuor.backend.models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Embeddable
public class StudentHasSessionPKey implements Serializable {
    String student_id;
    Integer session_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentHasSessionPKey that)) return false;
        return Objects.equals(student_id, that.student_id) &&
                Objects.equals(session_id, that.session_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, session_id);
    }

}
