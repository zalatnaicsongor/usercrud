package hu.zalatnai.usercrud.user.domain;

import java.util.UUID;

import hu.zalatnai.usercrud.user.infrastructure.entity.UserMementoEntity;
import hu.zalatnai.usercrud.user.infrastructure.entity.UserMementoJPARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
/**
 * Allows a collection-like access to the users. Delegates to the JPA-backed user memento repository
 * This could be further decoupled by creating Adapters should the need arise to support multiple db repos.
 */
public class UserRepository {
    private final UserMementoJPARepository repository;

    @Autowired
    public UserRepository(UserMementoJPARepository repository) {
        this.repository = repository;
    }

    public User get(UUID id) {
        return new User(repository.getOne(id));
    }

    public void add(User user) {
        repository.save((UserMementoEntity) user.getMemento());
    }

    public void remove(User user) {
        repository.delete((UserMementoEntity) user.getMemento());
    }
}
