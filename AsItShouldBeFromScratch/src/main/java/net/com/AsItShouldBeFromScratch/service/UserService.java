package net.com.AsItShouldBeFromScratch.service;

import net.com.AsItShouldBeFromScratch.model.User;
import net.com.AsItShouldBeFromScratch.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserController {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void saveOrUpdateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }

    @Override
    public void deleteAllUsers(Long id) {
        userRepository.deleteAll();
    }

    @Override
    public Optional<User> findByName(String username) {
        return userRepository.findUserByFirstName(username);
    }
}
