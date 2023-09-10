package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test,Integer> {
}
