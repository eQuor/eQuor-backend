package com.eQuor.backend.repositories;

import com.eQuor.backend.models.LecturerRegisterModule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "lecturer_register_module", path = "lecturer_register_module")
@CrossOrigin
public interface LecturerRegisterModuleRepository extends JpaRepository<LecturerRegisterModule,String> {
}
