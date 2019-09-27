package net.com.AsItShouldBeFromScratch.controller;

import net.com.AsItShouldBeFromScratch.model.User;
import net.com.AsItShouldBeFromScratch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users", produces = "application/json")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping(path = "/user/add")
    public User createUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user);
    }

    @PutMapping(path = "/user/update")
    public User updateUser(@RequestBody User user) {
        return userService.saveOrUpdateUser(user);
    }

    @GetMapping(path = "/user/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "/users/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

}

