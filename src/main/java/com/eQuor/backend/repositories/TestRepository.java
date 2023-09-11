package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TestRepository extends JpaRepository<Test,Integer> {
}
