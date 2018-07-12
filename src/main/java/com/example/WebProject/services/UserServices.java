package com.example.WebProject.services;

import com.example.WebProject.model.User;
import com.example.WebProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
public class UserServices {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/user/register")
    public User register(@RequestBody User user, HttpSession session) {
        User check = userRepository.findByUsername(user.getUsername());
        if (check == null) {
            User currentUser = userRepository.save(user);
            session.setAttribute("currentUser", currentUser);
            return currentUser;
        } else {
            User failed = new User();
            failed.invalidUser(user.getUsername());
            return failed;
        }
    }

    @GetMapping("/loginCheck")
    public User loginCheck(HttpSession session) {
        return (User) session.getAttribute("currentUser");
    }

    @PostMapping("/api/user/login")
    public User login(@RequestBody User user, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();
        User currentUser = userRepository.findByUsernameAndPassword(username, password);
        if (currentUser != null) {
            session.setAttribute("currentUser", currentUser);
            return currentUser;
        } else {
            User failed = new User();
            failed.invalidUser(user.getUsername());
            return failed;
        }

    }



}
