package com.example.WebProject.repository;

import com.example.WebProject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT user FROM User user WHERE user.username = :username")
    User findByUsername(@Param("username") String username);

    @Query("SELECT user FROM User user WHERE user.username = :username AND user.password = :password")
    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Query("DELETE FROM User user WHERE user.username = :username")
    void deleteByUsername(String username);
}
