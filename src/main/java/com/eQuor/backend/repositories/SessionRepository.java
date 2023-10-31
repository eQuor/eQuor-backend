package com.eQuor.backend.repositories;

import com.eQuor.backend.dto.GetSessionDTO;
import com.eQuor.backend.dto.StudentSessionDetails;
import com.eQuor.backend.models.Admin;
import com.eQuor.backend.models.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "session", path = "session")
@CrossOrigin
public interface SessionRepository  extends JpaRepository<Sessions,Integer> {
        Sessions findSessionsById(Integer id);

}