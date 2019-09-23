package net.com.AsItShouldBeFromScratch.AsItShouldBeFromScratch;

import net.com.AsItShouldBeFromScratch.model.Role;
import net.com.AsItShouldBeFromScratch.model.User;
import net.com.AsItShouldBeFromScratch.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
/*@SpringBootTest*/
@DataJpaTest
public class AsItShouldBeFromScratchApplicationTests {
    @Autowired
    UserRepository userRepositoryTest;

    @Test
    public void testStoreUser() {

        HashSet<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        User user = userRepositoryTest.save(new User(
                1L,
                "rom",
                "rom",
                "roman@ukr.net",
                "Romanте",
                "Vygovsky",
                roles));
        assertThat(user).isNotNull();
        assertThat(userRepositoryTest.count()).isEqualTo(1L);
    }


}
