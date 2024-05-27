package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pis.coursework.backend.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    User getUserByLogin(String login);

}
