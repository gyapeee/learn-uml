package com.gyapeee.learnuml.test;

import com.gyapeee.learnuml.model.User;
import com.gyapeee.learnuml.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties =
        {"spring.jpa.hibernate.ddl-auto=create-drop",
                "spring.datasource.initialization-mode=always"})
//@Rollback(value = false)
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUserWhenCreateInDbThenReadReturnsSame() {
        User user = new User();
        user.setEmail("d@email.com");
        user.setPassword("learnuml");
        user.setFirstName("d");
        user.setLastName("k");
//        user.setId(0l);

        User savedUser = userRepository.save(user);
        User readUser = entityManager.find(User.class, savedUser.getId());

        Assertions.assertEquals(user.getEmail(), readUser.getEmail());
    }
}
