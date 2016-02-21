package hu.zalatnai.usercrud.user.domain;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
/**
 * Allows a collection-like access to the users.
 */
public class UserRepository {
    User get(UUID id) {
        return null;
    }

    void add(User user) {

    }
}
