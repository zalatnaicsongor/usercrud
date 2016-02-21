package hu.zalatnai.usercrud.user.infrastructure.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

import hu.zalatnai.usercrud.user.domain.UserMemento;

public class UserEntity implements UserMemento {
    @Override
    public UUID getId() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public LocalDate getDateOfBirth() {
        return null;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {

    }

    @Override
    public Instant getCreated() {
        return null;
    }

    @Override
    public void setCreated(Instant created) {

    }

    @Override
    public Instant getModified() {
        return null;
    }

    @Override
    public void setModified(Instant modified) {

    }
}
