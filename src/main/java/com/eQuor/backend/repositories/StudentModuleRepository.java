package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Module;
import com.eQuor.backend.models.St_module;
import com.eQuor.backend.models.StudentModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "studentModule", path = "studentModule")
@CrossOrigin
public interface StudentModuleRepository extends JpaRepository<St_module, StudentModule> {


}
