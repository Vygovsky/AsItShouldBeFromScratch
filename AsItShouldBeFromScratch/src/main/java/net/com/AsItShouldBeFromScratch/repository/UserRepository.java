package net.com.AsItShouldBeFromScratch.repository;

import net.com.AsItShouldBeFromScratch.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
