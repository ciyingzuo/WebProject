package com.example.WebProject.repository;
import com.example.WebProject.model.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface WidgetRepository extends CrudRepository<Widget, Integer> {
}
