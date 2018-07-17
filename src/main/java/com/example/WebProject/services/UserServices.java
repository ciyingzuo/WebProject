package com.example.WebProject.services;

import com.example.WebProject.model.User;
import com.example.WebProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
public class UserServices {

    @Autowired
    UserRepository userRepository;


    /**
     * receive and check a user, if valid, save it to database.
     *
     * @param user user
     * @param session http session
     * @return a user to be saved or a invalid user if username already exist
     */
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

    /**
     * Save the http session for later use.
     *
     * @param session http session
     * @return User with saved session
     */
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


    /**
     * update the user information.
     *
     * @param id user id
     * @param user a user contains new information
     * @return a user contains updated information
     */
    @PutMapping("/api/user/update/{id}")
    public Optional<User> updateUser(@PathVariable Integer id, @RequestBody User user) {
        Optional<User> oldUser = userRepository.findById(id);
        User data = oldUser.get();
        data.setFirstName(user.getFirstName());
        data.setLastName(user.getLastName());
        data.setPassowrd(user.getPassword());
        data.setUsername(user.getUsername());
        data.setRole(user.getRole());
        data.setPhone(user.getPhone());
        data.setEmailAddress(user.getEmailAddress());
        data.setDate_of_birth(user.getDate_of_birth());
        userRepository.save(data);
        return userRepository.findById(id);
    }


    /**
     * delete a user from database.
     *
     * @param id user id
     */
    @DeleteMapping("/api/user/delete/{id}")
    public void deleteUserByID(@PathVariable Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    /**
     * find all users.
     *
     * @return a list with all users in database
     */
    @GetMapping("/api/user/findAll")
    public List<User> findAllUser() {
        return (List<User>) userRepository.findAll();
    }

    /**
     * find a user by user id.
     *
     * @param id user id
     * @return user with the same id
     */
    @GetMapping("/api/user/findById/{id}")
    public Optional<User> findUserById(@PathVariable Integer id) {
        return userRepository.findById(id);
    }
}
