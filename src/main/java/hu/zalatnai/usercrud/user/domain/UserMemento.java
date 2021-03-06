package hu.zalatnai.usercrud.user.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 * A contract for mementos holding the state of a User.
 */
public interface UserMemento {
    UUID getId();

    String getName();
    void setName(String name);

    LocalDate getDateOfBirth();
    void setDateOfBirth(LocalDate dateOfBirth);

    Instant getCreated();
    void setCreated(Instant created);

    Instant getModified();
    void setModified(Instant modified);
}