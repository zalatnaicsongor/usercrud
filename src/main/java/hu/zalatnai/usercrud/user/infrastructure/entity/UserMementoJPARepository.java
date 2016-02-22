package hu.zalatnai.usercrud.user.infrastructure.entity;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMementoJPARepository extends CrudRepository<UserMementoEntity, UUID> {
}
