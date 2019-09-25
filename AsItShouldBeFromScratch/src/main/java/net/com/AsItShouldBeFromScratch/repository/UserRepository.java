package net.com.AsItShouldBeFromScratch.repository;

import net.com.AsItShouldBeFromScratch.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findUserByFirstName(String username);

    Optional<User> findUserByLastName(String lastName);

    void deleteUserById(Long id);

}
