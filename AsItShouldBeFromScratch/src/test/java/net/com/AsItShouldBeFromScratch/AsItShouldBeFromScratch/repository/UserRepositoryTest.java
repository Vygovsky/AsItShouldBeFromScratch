package net.com.AsItShouldBeFromScratch.AsItShouldBeFromScratch.repository;

import net.com.AsItShouldBeFromScratch.model.Role;
import net.com.AsItShouldBeFromScratch.model.User;
import net.com.AsItShouldBeFromScratch.repository.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    private static final String USER_EMAIL = "roman@ukr.net";
    private static final String NAME = "Roman";
    private static final String LASTNAME = "Vygovsky";

    @Autowired
    UserRepository repository;


    @Before // эта хуйня сама быдет вызываться JUnit-ом

    public void insertUser() {
        System.out.println("******************************INSIDE INSERT_USER BEFORE TEST***************************");
        HashSet<Role> roles = new HashSet<>(Arrays.asList(Role.USER));
        repository.save(User.builder()
                .login("rom")
                .password("rom")
                .email(USER_EMAIL)
                .firstName(NAME)
                .lastName(LASTNAME)
                .roles(roles)
                .build());
    }

    @After
    public void clearDb() {
        System.out.println("******************************INSIDE CLEAR_DB AFTER TEST***************************");
        repository.deleteAll();
    }

    @Test
    public void saveUser_shouldSuccessfullySaveUser() {
        System.out.println("******************************INSIDE TEST***************************");
        // given

        // when
        User actualUser = repository.findByEmail(USER_EMAIL).get();

        //then
        assertThat(actualUser).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
        assertThat(actualUser.getId()).isNotNull();
        assertEquals(USER_EMAIL, actualUser.getEmail());
        assertThat(actualUser.getRoles().size()).isEqualTo(1);
        assertThat(actualUser.getRoles()).contains(Role.USER);
        assertThat(actualUser.getRoles()).doesNotContain(Role.ADMIN);
    }


    @Test
    public void findUserById_shouldSuccessfullyFindUserById() {
        assertTrue(true);
    }

    @Test
    public void findUserByUserName_shouldSuccessfullyFindUserByName() {
        System.out.println("******************************USERNAME TEST***************************");
        // when
        User actualUser = repository.findUserByFirstName(NAME).get();

        //then
        assertThat(actualUser).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
        assertThat(actualUser.getId()).isNotNull();
        assertEquals(NAME, actualUser.getFirstName());
        assertThat(actualUser.getRoles().size()).isEqualTo(1);
        assertThat(actualUser.getRoles()).contains(Role.USER);
        assertThat(actualUser.getRoles()).doesNotContain(Role.ADMIN);
    }

    @Test
    public void findUserByLastName_shouldSuccessfullyFindUserByLastName() {
        System.out.println("******************************LASTNAME TEST***************************");
        // when
        User actualUser = repository.findUserByLastName(LASTNAME).get();

        //then
        assertThat(actualUser).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
        assertThat(actualUser.getId()).isNotNull();
        assertEquals(LASTNAME, actualUser.getLastName());
        assertThat(actualUser.getRoles().size()).isEqualTo(1);
        assertThat(actualUser.getRoles()).contains(Role.USER);
        assertThat(actualUser.getRoles()).doesNotContain(Role.ADMIN);
    }
}
