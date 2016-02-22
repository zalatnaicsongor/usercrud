package hu.zalatnai.usercrud.user.infrastructure.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import hu.zalatnai.usercrud.user.domain.UserMemento;
import hu.zalatnai.usercrud.user.domain.UserMementoFactory;

import org.springframework.stereotype.Service;

@Service
public class UserMementoEntityFactory implements UserMementoFactory {
    @Override
    public UserMemento create(UUID id, String name, LocalDate dateOfBirth, Instant created, Instant modified) {
        UserMementoEntity entity = new UserMementoEntity(id);

        entity.setName(name);
        entity.setDateOfBirth(dateOfBirth);
        entity.setCreated(created);
        entity.setModified(modified);

        return entity;
    }
}
