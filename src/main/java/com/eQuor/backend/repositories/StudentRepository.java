package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Module;
import com.eQuor.backend.models.Staff;
import com.eQuor.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "student", path = "student")
@CrossOrigin
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByUsername(String username);

    @Query(value = "SELECT s.name, s.email FROM student s INNER JOIN student_register_modules srm ON s.id = srm.student_id WHERE srm.module_id = :moduleId", nativeQuery = true)
    List<Object[]> findStudentsByModuleId(@Param("moduleId") int moduleId);

}
