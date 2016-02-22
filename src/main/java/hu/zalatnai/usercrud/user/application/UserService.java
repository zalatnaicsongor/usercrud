package hu.zalatnai.usercrud.user.application;

import java.time.LocalDate;
import java.util.UUID;

import hu.zalatnai.usercrud.user.domain.User;
import hu.zalatnai.usercrud.user.domain.UserFactory;
import hu.zalatnai.usercrud.user.domain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
/**
 * A CRUD service class to manipulate Users.
 * Testing is omitted, but very straightforward.
 */
public class UserService {
    private final UserRepository userRepository;
    private final UserFactory userFactory;

    @Autowired
    UserService(UserRepository userRepository, UserFactory userFactory) {
        this.userRepository = userRepository;
        this.userFactory = userFactory;
    }

    @Transactional
    public User createUser(String name, LocalDate dateOfBirth) {
        User user = userFactory.create(name, dateOfBirth);
        userRepository.add(user);

        return user;
    }

    @Transactional(readOnly = true)
    public User getUser(UUID id) {
        return userRepository.get(id);
    }

    @Transactional
    public void deleteUser(UUID id) {
        userRepository.remove(userRepository.get(id));
    }

    @Transactional
    public void modifyUser(UUID id, UserChangeSet userChangeSet) {
        User user = getUser(id);

        if (userChangeSet.shouldChangeName()) {
            user.changeName(userChangeSet.getName());
        }

        if (userChangeSet.shouldChangeDateOfBirth()) {
            user.changeDateOfBirth(userChangeSet.getDateOfBirth());
        }
    }
}
