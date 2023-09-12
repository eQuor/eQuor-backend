package com.eQuor.backend.repositories;

import com.eQuor.backend.models.APIRequest;
import com.eQuor.backend.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "staff", path = "staff")
@CrossOrigin
public interface StaffRepository extends JpaRepository<Staff,Integer> {
}
