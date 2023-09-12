package com.eQuor.backend.repositories;

import com.eQuor.backend.models.APIRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "apiRequests", path = "apiRequests")
@CrossOrigin
public interface ApiRequestRepository extends JpaRepository<APIRequest,Integer> {
}
