package hu.zalatnai.usercrud.user.domain;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 * The contract of creating new mementos which holds the state of a User.
 */
public interface UserMementoFactory {
    UserMemento create(UUID id, String name, LocalDate dateOfBirth, Instant created, Instant modified);
}
