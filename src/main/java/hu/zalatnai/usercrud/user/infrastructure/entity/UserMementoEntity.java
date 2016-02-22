package hu.zalatnai.usercrud.user.infrastructure.entity;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import hu.zalatnai.usercrud.user.domain.UserMemento;

import org.springframework.data.domain.Persistable;

@Entity
public class UserMementoEntity implements UserMemento, Persistable<UUID> {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private Instant created;

    @Column(nullable = false)
    private Instant modified;

    private transient boolean isNew = false;


    public UserMementoEntity(UUID id) {
        this.id = id;
        this.isNew = true;
    }

    UserMementoEntity() {
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public Instant getCreated() {
        return created;
    }

    @Override
    public void setCreated(Instant created) {
        this.created = created;
    }

    @Override
    public Instant getModified() {
        return modified;
    }

    @Override
    public void setModified(Instant modified) {
        this.modified = modified;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
