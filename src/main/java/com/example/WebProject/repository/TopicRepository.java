package com.example.WebProject.repository;

import com.example.WebProject.model.Topic;
import org.springframework.data.repository.CrudRepository;
public interface TopicRepository extends CrudRepository<Topic, Integer> {
}
