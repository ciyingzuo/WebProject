package com.example.WebProject.repository;
import com.example.WebProject.model.Topic;
import com.example.WebProject.model.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {
    @Query("SELECT widget FROM Widget widget WHERE widget.topic = :topic")
    List<Widget> findByTopic(@Param("topic") Topic topic);
}
