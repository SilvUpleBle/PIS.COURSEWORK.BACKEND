package pis.coursework.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pis.coursework.backend.entity.UserRole;

import java.util.ArrayList;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole, Long> {

    UserRole getUserRoleById(Long userRoleId);

    @Query(value = "SELECT * FROM user_role", nativeQuery = true)
    ArrayList<UserRole> getAllUserRoles();
    
}
