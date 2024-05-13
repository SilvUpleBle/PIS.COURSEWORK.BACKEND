package pis.coursework.backend.dto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pis.coursework.backend.dto.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
