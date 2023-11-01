package com.eQuor.backend.repositories;

import com.eQuor.backend.models.StudentHasSession;
import com.eQuor.backend.models.StudentHasSessionPKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface StudentHasSessionRepository extends JpaRepository<StudentHasSession, StudentHasSessionPKey> {

    @Query (value = "SELECT S FROM StudentHasSession S WHERE S.pkey.student_id = :id and S.pkey.session_id = :sid")
    StudentHasSession findUserById(@Param("id") String id,@Param("sid") Integer sid ) ;

    StudentHasSession findByPkey(StudentHasSessionPKey studentHasSessionPKey);
}
