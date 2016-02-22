package hu.zalatnai.usercrud.user.domain;

import java.time.LocalDate;

/**
 * The contract of creating a new User.
 */
public interface UserFactory {
    /**
     * Creates a new domain entity representing a user
     * @param name the nme of the user
     * @param dateOfBirth the user's date of birth
     * @return a new domain entity which represents the User
     */
    User create(String name, LocalDate dateOfBirth);
}
