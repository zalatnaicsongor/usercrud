package hu.zalatnai.usercrud.user.domain;

import java.time.Instant;
import java.time.LocalDate;

public class User {
    private UserMemento memento;

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
     * Instantiates a user from an existing state
     * @param memento a memento which holds the state of the user
     */
    User(UserMemento memento) {
        this.memento = memento;
    }
}
