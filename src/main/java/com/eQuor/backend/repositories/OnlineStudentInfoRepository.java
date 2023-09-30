package com.eQuor.backend.repositories;

import com.eQuor.backend.models.OnlineStudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OnlineStudentInfoRepository extends JpaRepository<OnlineStudentInfo,String> {
    @Query(value = "SELECT s.id AS student_id, s.name AS student_name, s.email AS student_email, shs.is_joined FROM student_has_session shs INNER JOIN student s ON shs.student_id = s.id WHERE shs.session_id = ?;",nativeQuery = true)
    List<OnlineStudentInfo> getAllOnlineStudentBySessionId(Integer session_id);
}
