package net.com.AsItShouldBeFromScratch.service;

import net.com.AsItShouldBeFromScratch.model.User;

import java.util.Optional;

public interface IUserController {
    Iterable<User> findAll();

    Optional<User> getUserById(Long id);

    void saveOrUpdateUser(User user);

    void deleteUser(Long id);

    void deleteAllUsers();

    Optional<User> findByName(String username);
}
