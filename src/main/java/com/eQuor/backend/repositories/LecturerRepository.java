package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Lecturer;
import com.eQuor.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "lecturer", path = "lecturer")
@CrossOrigin
public interface LecturerRepository extends JpaRepository<Lecturer,Integer> {
    Lecturer findByUsername(String username);
}
