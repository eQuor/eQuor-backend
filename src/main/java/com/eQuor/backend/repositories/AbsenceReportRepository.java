package com.eQuor.backend.repositories;

import com.eQuor.backend.models.AbsenceReport;
import com.eQuor.backend.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "absencereport" ,path = "absencereport")
@CrossOrigin

public interface AbsenceReportRepository extends JpaRepository<AbsenceReport,Integer> {

}
