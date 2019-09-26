package net.com.AsItShouldBeFromScratch.controller;

import net.com.AsItShouldBeFromScratch.model.User;
import net.com.AsItShouldBeFromScratch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path="/users", produces = "application/json")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
