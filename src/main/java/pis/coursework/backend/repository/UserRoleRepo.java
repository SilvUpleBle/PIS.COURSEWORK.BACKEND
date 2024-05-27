package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
}
