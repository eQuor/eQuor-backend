package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Admin;
import com.eQuor.backend.models.Sessions;
import jakarta.websocket.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "session", path = "session")
@CrossOrigin
public interface SessionRepository  extends JpaRepository<Sessions,Integer> {

//    @Query()
//    String insertQrSequence(@Param("moduleId") int moduleId);
    Sessions findById(int id);
    Sessions findSessionsById(Integer id);

//    List<Sessions> findByModule_id(int id);

    //List<Sessions> findSessionsByModule_id(int id);
//    @Query(value = "SELECT * FROM sessions WHERE module_id = :moduleId", nativeQuery = true)
//    List<Session> findByModuleId(@Param("moduleId") Integer moduleId);

    @Query(value = "SELECT * FROM \"session\" WHERE module_id = :moduleId", nativeQuery = true)
    List<Sessions> findByModuleId(@Param("moduleId") Integer moduleId);

    @Query("SELECT COUNT(s) FROM Sessions s WHERE s.module_id = :moduleId")
    Integer countByModuleId(@Param("moduleId") Integer moduleId);

    @Query("SELECT COUNT(s) FROM Student_attend_session sat INNER JOIN Sessions s ON s.id = sat.id.session_id WHERE sat.id.student_id = :student_id AND s.module_id = :module_id")
    Integer countByMAttendance(@Param("student_id") String student_id, @Param("module_id") Integer moduleId);




}