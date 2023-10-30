package com.eQuor.backend.repositories;

import com.eQuor.backend.models.St_attend;
import com.eQuor.backend.models.Staff;
import com.eQuor.backend.models.Student_attend_session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "studentAttendSession", path = "studentAttendSession")
@CrossOrigin
public interface StudentAttendSessionRepository extends JpaRepository<Student_attend_session, St_attend> {

//    @Query("SELECT COUNT(*) FROM student_attend_session")
//    Integer getCountForSession();

}
