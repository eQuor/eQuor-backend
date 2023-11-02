package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "mobile", path = "mobile")
@CrossOrigin
public interface MobileRepository extends JpaRepository<Mobile, String> {
}
