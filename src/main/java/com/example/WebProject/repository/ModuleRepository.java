package com.example.WebProject.repository;

import com.example.WebProject.model.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Integer> {

//    @Query("SELECT module FROM Module module WHERE module.course_id = :course_id")
//    List<Module> findByCourseId(@Param("course_id") Integer course_id);
}
