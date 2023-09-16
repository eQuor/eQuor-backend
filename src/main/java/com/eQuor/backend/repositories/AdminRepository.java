package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Admin;
import com.eQuor.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "admin", path = "admin")
@CrossOrigin
public interface AdminRepository extends JpaRepository<Admin,Integer> {

    Admin findByUsername(String username);
}
