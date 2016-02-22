package hu.zalatnai.usercrud.user.domain;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
/**
 * Allows a collection-like access to the users. Delegates to the JPA-backed user memento repository
 */
public class UserRepository {
    User get(UUID id) {
        return null;
    }

    void add(User user) {

    }
}
