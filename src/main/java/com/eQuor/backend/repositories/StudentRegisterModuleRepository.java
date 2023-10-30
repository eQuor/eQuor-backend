package com.eQuor.backend.repositories;

import com.eQuor.backend.models.LecturerRegisterModule;

import com.eQuor.backend.models.StudentRegisterModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "student_register_module", path = "student_register_module")
@CrossOrigin
public interface StudentRegisterModuleRepository extends JpaRepository<StudentRegisterModule,String> {
}
