package hu.zalatnai.usercrud.user.domain;

import java.time.LocalDate;

/**
 * An interface which defines the contract of creating a new user.
 */
public interface UserFactory {
    User create(String name, LocalDate dob);
}
