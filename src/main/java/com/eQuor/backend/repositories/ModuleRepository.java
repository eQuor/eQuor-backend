package com.eQuor.backend.repositories;

import com.eQuor.backend.models.Module;
import com.eQuor.backend.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Objects;


@RepositoryRestResource(collectionResourceRel = "module", path = "module")
@CrossOrigin
public interface ModuleRepository extends JpaRepository<Module,Integer> {

    Module findById(int id);

    @Query(value = "SELECT m FROM LecturerRegisterModule l INNER JOIN Module m on l.module_id = m.id where l.lecturer_id = :lecturer_id")
    List<Module> getModuleByLecId(@Param("lecturer_id") String lecturer_id);

    @Query(value = "SELECT m FROM StudentRegisterModule l INNER JOIN Module m on l.module_id = m.id where l.student_id = :student_id")
    List<Module> getStudentModuleByStudentId(@Param("student_id") String student_id );

    @Query("SELECT m FROM LecturerRegisterModule lm INNER JOIN Module m ON m.id =lm.module_id WHERE lm.lecturer_id = :lecture_id")
    List<Module> lectureByModule(@Param("lecture_id") String lecture_id);

}
