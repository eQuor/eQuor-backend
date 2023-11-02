package com.eQuor.backend.repositories;

import com.eQuor.backend.models.LecturerRegisterModule;

import com.eQuor.backend.models.StudentRegisterModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "student_register_module", path = "student_register_module")
@CrossOrigin
public interface StudentRegisterModuleRepository extends JpaRepository<StudentRegisterModule,String> {

    @Query(value = "SELECT s from StudentRegisterModule s Where s.module_id = :module_id")
    List<StudentRegisterModule> findbyModuleId(@Param("module_id")Integer module_id);
}
