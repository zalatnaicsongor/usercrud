package hu.zalatnai.usercrud.user.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Creates new Users.
 */
@Service
public class UserFactory {
    private final UserMementoFactory userMementoFactory;

    @Autowired
    UserFactory(UserMementoFactory userMementoFactory) {
        this.userMementoFactory = userMementoFactory;
    }

    /**
     * Creates a new domain entity representing a user
     *
     * @param name        the name of the user
     * @param dateOfBirth the user's date of birth
     * @return a new domain entity which represents the User
     */
    public User create(String name, LocalDate dateOfBirth) {
        Assert.hasText(name);
        Assert.notNull(dateOfBirth);

        Instant now = Instant.now();
        UUID id = UUID.randomUUID();

        UserMemento memento = userMementoFactory.create(id, name, dateOfBirth, now, now);

        return new User(memento);
    }
}
