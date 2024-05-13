package pis.coursework.backend.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.dto.entity.UserRole;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
}