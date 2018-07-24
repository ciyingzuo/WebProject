package com.example.WebProject.repository;

import com.example.WebProject.model.Lesson;
import com.example.WebProject.model.Module;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, Integer> {
    @Query("SELECT lesson FROM Lesson lesson WHERE lesson.module = :module")
    List<Lesson> findByModuleId(@Param("module") Module module);
}