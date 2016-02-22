package hu.zalatnai.usercrud.user.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.util.Assert;

/**
 * A domain entity representing a User. Its state is extracted into a memento.
 */
public class User {
    private UserMemento memento;

    public UUID getId() {
        return memento.getId();
    }

    public String getName() {
        return memento.getName();
    }

    public LocalDate getDateOfBirth() {
        return memento.getDateOfBirth();
    }

    public Instant getCreated() {
        return memento.getCreated();
    }

    public Instant getModified() {
        return memento.getModified();
    }

    /**
     * Changes the date of birth of the user
     * @param dateOfBirth new date of birth
     */
    public void changeDateOfBirth(LocalDate dateOfBirth) {
        Assert.notNull(dateOfBirth);

        memento.setDateOfBirth(dateOfBirth);
        memento.setModified(Instant.now());
    }

    /**
     * Changes the name of the user.
     * @param name new name of the user
     */
    public void changeName(String name) {
        Assert.hasText(name);

        memento.setName(name);
        memento.setModified(Instant.now());
    }

    /**
     * Instantiates a user from an existing state
     * @param memento a memento which holds the state of the user
     */
    User(UserMemento memento) {
        this.memento = memento;
    }
}
