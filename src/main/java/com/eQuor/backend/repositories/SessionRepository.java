package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Admin;
import com.eQuor.backend.models.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "session", path = "session")
@CrossOrigin
public interface SessionRepository  extends JpaRepository<Sessions,Integer> {


}