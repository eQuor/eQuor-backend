package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Staff;
import com.eQuor.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "student", path = "student")
@CrossOrigin
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByUsername(String username);
}
