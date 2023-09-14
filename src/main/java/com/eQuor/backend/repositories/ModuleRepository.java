package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Module;
import com.eQuor.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "module", path = "module")
@CrossOrigin
public interface ModuleRepository extends JpaRepository<Module,Integer> {

}
