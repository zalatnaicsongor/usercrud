package hu.zalatnai.usercrud.user.infrastructure.entity;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMementoJPARepository extends JpaRepository<UserMementoEntity, UUID> {
}
