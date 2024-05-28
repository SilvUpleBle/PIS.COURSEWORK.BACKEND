package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.User;

import java.util.ArrayList;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User getUserById(Long userId);
    User getUserByLogin(String login);

    @Query(value = "SELECT * FROM users", nativeQuery = true)
    ArrayList<User> getAllUsers();

}
