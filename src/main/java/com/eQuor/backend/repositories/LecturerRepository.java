package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Lecturer;
import com.eQuor.backend.models.Student;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "lecturer", path = "lecturer")
@CrossOrigin
public interface LecturerRepository extends JpaRepository<Lecturer,String> {
    Lecturer findByUsername(String username);

//    @Query(value = "SELECT l.name FROM lecturer l INNER JOIN lecturer_register_module lrm ON l.id = lrm.lecturer_id WHERE lrm.module_id = :moduleId", nativeQuery = true)
//    List<String> findLecturersByModuleId(@Param("moduleId") int moduleId);

//    @Query(value = "SELECT l.name, l.email FROM lecturer l INNER JOIN lecturer_register_module lrm ON l.id = lrm.lecturer_id WHERE lrm.module_id = :moduleId", nativeQuery = true)
//    List<Object[]> findLecturersByModuleId(@Param("moduleId") int moduleId);

    @Query(value = "SELECT l.name, l.email FROM lecturer l INNER JOIN lecturer_register_module lrm ON l.id = lrm.lecturer_id WHERE lrm.module_id = :moduleId", nativeQuery = true)
    List<Object[]> findLecturersByModuleId(@Param("moduleId") int moduleId);
}
